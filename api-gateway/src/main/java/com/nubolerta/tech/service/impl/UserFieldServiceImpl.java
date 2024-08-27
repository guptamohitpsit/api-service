package com.nubolerta.tech.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nubolerta.tech.dto.UserRequestDto;
import com.nubolerta.tech.dto.UserResponseDto;
import com.nubolerta.tech.entity.MandatoryField;
import com.nubolerta.tech.entity.UserInformation;
import com.nubolerta.tech.exception.ResourceNotFoundException;
import com.nubolerta.tech.repository.MandatoryFieldRespository;
import com.nubolerta.tech.repository.UserInformationRepository;
import com.nubolerta.tech.service.UserFieldService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserFieldServiceImpl implements UserFieldService {

    @Autowired
    private UserInformationRepository userRepository;

    @Autowired
    private MandatoryFieldRespository requiredFieldRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FeignClientService feignClientService;

    @Override
    public UserResponseDto getMissingFields(Long userId) {

        UserInformation user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));

        Map<String, Object> userMap = objectMapper.convertValue(user, Map.class);
        List<MandatoryField> requiredFields = requiredFieldRepository.findAll();

        Map<String, Object> missingFields = new HashMap<>();
        Map<String, Object> availableField = new HashMap<>();

        for (MandatoryField requirement : requiredFields) {
            String fieldName = requirement.getFieldName();
            if (userMap.get(fieldName) == null) {
                missingFields.put(fieldName, null);
            } else {
                availableField.put(fieldName, userMap.get(fieldName));
            }
        }
        UserResponseDto userResponseDto = UserResponseDto.builder()
                .missingField(missingFields).availableField(availableField)
                .build();

        return userResponseDto;
    }

    @Override
    public void saveUserformation(UserRequestDto userRequestDto) {
        UserInformation userInformation = new UserInformation();
        BeanUtils.copyProperties(userRequestDto, userInformation);
        userInformation = userRepository.save(userInformation);
        feignClientService.callExternalService(userInformation.getId());
    }

}
