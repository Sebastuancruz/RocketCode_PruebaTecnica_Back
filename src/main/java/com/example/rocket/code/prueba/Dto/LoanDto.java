package com.example.rocket.code.prueba.Dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {
    
    private Long bookId;
    private Long studentId;
    private LocalDate returnDate;

}
