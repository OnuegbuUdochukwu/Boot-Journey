package com.codewithudo.elibrarybooklending.repository;


import com.codewithudo.elibrarybooklending.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}