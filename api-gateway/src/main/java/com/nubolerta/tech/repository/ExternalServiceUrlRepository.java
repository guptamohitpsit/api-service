package com.nubolerta.tech.repository;

import com.nubolerta.tech.entity.ExternalServiceUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternalServiceUrlRepository extends JpaRepository<ExternalServiceUrl, Long> {

    ExternalServiceUrl findByServiceProviderName(String test);
}

