package com.nubolerta.tech.repository;

import com.nubolerta.tech.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {

    Optional<UserInformation> findByFirstName(String userId);
}
