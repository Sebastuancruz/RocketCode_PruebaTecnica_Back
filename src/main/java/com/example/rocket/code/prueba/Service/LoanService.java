package com.example.rocket.code.prueba.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rocket.code.prueba.Dto.LoanDto;
import com.example.rocket.code.prueba.Entity.Book;
import com.example.rocket.code.prueba.Entity.Loan;
import com.example.rocket.code.prueba.Entity.UserPlatform;
import com.example.rocket.code.prueba.Repository.BookRepository;
import com.example.rocket.code.prueba.Repository.LoanRepository;
import com.example.rocket.code.prueba.Repository.UserPlatformRepository;

@Service
public class LoanService {
    
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserPlatformRepository userPlatformRepository;

    public Loan createLoan(LoanDto loanDto) {
    Book book = bookRepository.findById(loanDto.getBookId())
            .orElseThrow(() -> new RuntimeException("El libro no existe"));

    if (book.getAvailableQuantity() <= 0) {
        throw new RuntimeException("No hay unidades disponibles para el libro: " + book.getTitle());
    }

    UserPlatform student = userPlatformRepository.findById(loanDto.getStudentId())
            .orElseThrow(() -> new RuntimeException("El estudiante no existe"));

    book.setAvailableQuantity(book.getAvailableQuantity() - 1);
    bookRepository.save(book);

    Loan loan = Loan.builder()
            .book(book)
            .student(student)
            .loanDate(LocalDate.now())
            .returnDate(loanDto.getReturnDate())
            .returned(false)
            .build();

    return loanRepository.save(loan);
    }

    public Loan returnLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("El préstamo no existe"));

        if (loan.isReturned()) {
            throw new RuntimeException("El préstamo ya fue devuelto");
        }

        Book book = loan.getBook();
        book.setAvailableQuantity(book.getAvailableQuantity() + 1);
        bookRepository.save(book);

        loan.setReturned(true);
        loan.setReturnDate(LocalDate.now());
        return loanRepository.save(loan);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findByBookReturnedFalse();
    }

    public List<Loan> getLoansByStudent(Long studentId) {
        return loanRepository.findByStudentId(studentId);
    }

    public List<UserPlatform> getStudents(){
        return userPlatformRepository.findByRole("STUDENT");
    }

}
