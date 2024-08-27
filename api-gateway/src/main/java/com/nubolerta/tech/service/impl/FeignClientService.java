package com.nubolerta.tech.service.impl;

import com.nubolerta.tech.client.ThirdPartyServiceClient;
import com.nubolerta.tech.entity.ExternalServiceUrl;
import com.nubolerta.tech.repository.ExternalServiceUrlRepository;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Import(FeignClientsConfiguration.class)
@Slf4j
public class FeignClientService {

    @Autowired
    private ExternalServiceUrlRepository urlRepository;

    public void callExternalService(Long id) {

        ExternalServiceUrl serviceUrl = urlRepository.findByServiceProviderName("Test");

        ThirdPartyServiceClient client = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(ThirdPartyServiceClient.class, serviceUrl.getServiceUrl());

        // Call third-party service
        Map<String, Object> thirdPartyResponse = client.submitUserInfo(id);
    }
}
