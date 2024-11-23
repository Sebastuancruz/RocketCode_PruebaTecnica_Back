package com.example.rocket.code.prueba.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rocket.code.prueba.Dto.CreateBookDto;
import com.example.rocket.code.prueba.Entity.Book;
import com.example.rocket.code.prueba.Repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(CreateBookDto book) {

        Book registerBook = Book.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .totalQuantity(book.getTotalQuantity())
                .availableQuantity(book.getTotalQuantity())
                .registeredBy(book.getRegisteredBy())
                .build();

        return bookRepository.save(registerBook);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBook(Long id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            return bookRepository.save(book);
        }
        return null;
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
