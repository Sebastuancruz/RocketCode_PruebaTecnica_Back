package com.example.rocket.code.prueba.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rocket.code.prueba.Dto.LoanDto;
import com.example.rocket.code.prueba.Entity.Loan;
import com.example.rocket.code.prueba.Entity.UserPlatform;
import com.example.rocket.code.prueba.Service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
    
    @Autowired
    private LoanService loanService;

    @Secured("STUDENT")
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Loan>> getLoansByStudent(@PathVariable Long studentId) {
        List<Loan> loans = loanService.getLoansByStudent(studentId);
        return ResponseEntity.ok(loans);
    }

    @PostMapping
    @Secured("ADMIN")
    public ResponseEntity<Loan> createLoan(@RequestBody LoanDto loan) {
        Loan createdLoan = loanService.createLoan(loan);
        return ResponseEntity.ok(createdLoan);
    }

    @Secured("ADMIN")
    @PutMapping("/{id}/return")
    public ResponseEntity<Loan> returnLoan(@PathVariable Long id) {
        Loan returnedLoan = loanService.returnLoan(id);
        return ResponseEntity.ok(returnedLoan);
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @Secured("ADMIN")
    @GetMapping("students")
    public ResponseEntity<List<UserPlatform>> getStudents() {
        return ResponseEntity.ok(loanService.getStudents());
    }

}
