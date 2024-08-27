package com.nubolerta.tech.controller;

import com.nubolerta.tech.dto.UserRequestDto;
import com.nubolerta.tech.dto.UserResponseDto;
import com.nubolerta.tech.service.UserFieldService;
import com.nubolerta.tech.service.impl.FeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserFormController {

    @Autowired
    private UserFieldService userFieldService;

    @Autowired
    FeignClientService feignClientService;

    @GetMapping("/missingFields/{userId}")
    public ResponseEntity<UserResponseDto> getMissingFields(@PathVariable Long userId) {
        UserResponseDto missingFields = userFieldService.getMissingFields(userId);
        return ResponseEntity.ok(missingFields);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUserformation(@Validated @RequestBody UserRequestDto userRequestDto) {
        userFieldService.saveUserformation(userRequestDto);
        return ResponseEntity.ok("Form submitted successfully.");
    }
}
