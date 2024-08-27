package com.nubolerta.tech.client;

import com.nubolerta.tech.config.DynamicFeignConfig;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "thirdPartyServiceClient", configuration = DynamicFeignConfig.class)
public interface ThirdPartyServiceClient {

    @RequestLine("GET /users/{userId}")
    Map<String, Object> submitUserInfo(@PathVariable("userId") Long userId);

}


