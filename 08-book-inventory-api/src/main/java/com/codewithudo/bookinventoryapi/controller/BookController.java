package com.codewithudo.bookinventoryapi.controller;

import com.codewithudo.bookinventoryapi.model.Book;
import com.codewithudo.bookinventoryapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<ArrayList<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(),  HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book foundbook = bookService.getBookById(id);
        if (foundbook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(foundbook, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<ArrayList<Book>> addBook(@RequestBody Book book) {
        ArrayList<Book> books = bookService.addBook(book);
        return new ResponseEntity<>(books, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable int id, @RequestBody Book book) {
        boolean updated = bookService.updateBook(id, book);
        if (updated) {
            return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        boolean deleted = bookService.deleteBookById(id);
        if (deleted) {
            return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
    }
}
