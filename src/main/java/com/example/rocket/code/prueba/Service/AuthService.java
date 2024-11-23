package com.example.rocket.code.prueba.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.rocket.code.prueba.Dto.AuthResponse;
import com.example.rocket.code.prueba.Dto.CreateAccountDto;
import com.example.rocket.code.prueba.Dto.LoginDto;
import com.example.rocket.code.prueba.Dto.MessageDto;
import com.example.rocket.code.prueba.Entity.UserPlatform;
import com.example.rocket.code.prueba.Repository.UserPlatformRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    @Autowired
    private UserPlatformRepository userPlatformRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public AuthResponse login(LoginDto datos) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(datos.getEmail(), datos.getPassword()));
        UserDetails user = userPlatformRepository.findByEmail(datos.getEmail()).orElseThrow();

        UserPlatform usuariosPlataforma = userPlatformRepository.findByEmail(datos.getEmail()).orElseThrow();

        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .nombre(usuariosPlataforma.getName())
                .rol(usuariosPlataforma.getRole())
                .id(usuariosPlataforma.getId())
                .build();
    }

    public MessageDto register(CreateAccountDto data){

        Optional<UserPlatform> user = userPlatformRepository.findByEmail(data.getEmail());

        if (user.isPresent()) {
            throw new RuntimeException("Ya existe un usuario con ese email");
        }

        UserPlatform userPlatform = null;

        if (data.getRole().equals("STUDENT")){
            userPlatform = UserPlatform.builder()
                .email(data.getEmail())
                .password(encodePassword(data.getPassword()))
                .name(data.getName())
                .role("STUDENT")
                .build();
        } 

        if (data.getRole().equals("ADMIN")){
            userPlatform = UserPlatform.builder()
                .email(data.getEmail())
                .password(encodePassword(data.getPassword()))
                .name(data.getName())
                .role("ADMIN")
                .build();
        }


        userPlatformRepository.save(userPlatform);


        return MessageDto.builder().message("Usuario registrado exitosamente").build();
    }
}
