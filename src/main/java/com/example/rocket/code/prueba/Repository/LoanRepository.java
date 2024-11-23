package com.example.rocket.code.prueba.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.rocket.code.prueba.Entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {  
    @Query("SELECT l FROM Loan l WHERE l.student.id = :studentId AND l.returned = false")
    List<Loan> findByStudentId(Long studentId);

    @Query("SELECT l FROM Loan l WHERE l.returned = false")
    List<Loan> findByBookReturnedFalse();
}
