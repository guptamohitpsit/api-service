package com.nubolerta.tech.service;

import com.nubolerta.tech.dto.UserRequestDto;
import com.nubolerta.tech.dto.UserResponseDto;

import java.util.List;

public interface UserFieldService {
    UserResponseDto getMissingFields(Long userId);
    void saveUserformation(UserRequestDto userRequestDto);
}
