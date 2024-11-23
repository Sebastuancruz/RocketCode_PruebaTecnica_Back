package com.example.rocket.code.prueba.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountDto {
    private String name;
    private String email;
    private String password;
    private String role;
}
