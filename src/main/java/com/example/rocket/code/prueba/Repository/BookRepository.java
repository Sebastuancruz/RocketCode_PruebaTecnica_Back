package com.example.rocket.code.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rocket.code.prueba.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    
}
