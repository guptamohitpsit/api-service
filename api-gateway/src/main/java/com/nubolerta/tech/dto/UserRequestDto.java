package com.nubolerta.tech.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequestDto {
    private Long Id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String birthPlace;
    private String sex;
    private String currentAddress;

}
