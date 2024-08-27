package com.nubolerta.tech.repository;


import com.nubolerta.tech.entity.MandatoryField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MandatoryFieldRespository extends JpaRepository<MandatoryField, Long> {

}
