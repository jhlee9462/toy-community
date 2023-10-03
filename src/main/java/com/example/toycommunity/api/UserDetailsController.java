package com.example.toycommunity.api;

import com.example.toycommunity.dto.request.UserSignUpRequestDto;
import com.example.toycommunity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/users")
public class UserDetailsController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> signUp(@Validated @RequestBody UserSignUpRequestDto userSignUpRequestDto) {

        log.info("/api/v1/users : POST!!");

        userService.signUp(userSignUpRequestDto);
        return ResponseEntity.ok().build();
    }

}
