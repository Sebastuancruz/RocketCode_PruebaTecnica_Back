package com.example.rocket.code.prueba.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rocket.code.prueba.Dto.CreateAccountDto;
import com.example.rocket.code.prueba.Dto.LoginDto;
import com.example.rocket.code.prueba.Dto.MessageDto;
import com.example.rocket.code.prueba.Service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<MessageDto> registerStudent(@RequestBody CreateAccountDto request) {
            return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto request) {
            return ResponseEntity.ok(authService.login(request));
    }

}
