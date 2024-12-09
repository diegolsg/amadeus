package com.amadeus.horas_extras.adapter.api.controller;



import com.amadeus.horas_extras.adapter.api.dtos.JWTResponseDto;
import com.amadeus.horas_extras.adapter.api.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    private JwtUtil jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<JWTResponseDto> login(@RequestParam String email, @RequestParam String password) {

        String role = "ROLE_USER";
        String token = jwtUtils.generateToken(email, role);

        JWTResponseDto response = new JWTResponseDto(token);
        return ResponseEntity.ok(response);
    }
}


