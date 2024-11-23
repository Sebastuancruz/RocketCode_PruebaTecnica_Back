package com.example.rocket.code.prueba.Dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookDto {
  
    private String title;
    private String author;
    private int totalQuantity;
    private String registeredBy;
}
