package com.microservice.demo.controller;

import com.microservice.demo.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by: Tharindu Eranga
 * Date: 28 May 2022
 **/
@Slf4j
@RequiredArgsConstructor
@RestController
public class AuthRestController {

    private final JwtUtil jwtUtil;

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody String userName) {
        String token = jwtUtil.generateToken(userName);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/auth/register")
    public ResponseEntity<String> register(@RequestBody String userName) {
        // Persist user to some persistent storage
        log.info("Info saved...");

        return new ResponseEntity<>("Registered", HttpStatus.OK);
    }

}