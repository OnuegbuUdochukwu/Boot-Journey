package com.codewithudo.elibrarybooklending.controller;

import com.codewithudo.elibrarybooklending.dto.BorrowRequest;
import com.codewithudo.elibrarybooklending.dto.ReturnRequest;
import com.codewithudo.elibrarybooklending.model.Book;
import com.codewithudo.elibrarybooklending.model.BorrowRecord;
import com.codewithudo.elibrarybooklending.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    // 📚 Get all books
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(libraryService.getAllBooks());
    }

    // ➕ Add a new book
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(libraryService.addBook(book));
    }

    // 🔍 Get a book by ID
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return libraryService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 📥 Borrow a book
    @PostMapping("/borrow")
    public ResponseEntity<?> borrowBook(@RequestBody BorrowRequest request) {
        return libraryService.borrowBook(request)
                .map(book -> ResponseEntity.ok("Book borrowed: " + book.getTitle()))
                .orElse(ResponseEntity.badRequest().body("Book unavailable or not found."));
    }

    // 📤 Return a book
    @PostMapping("/return")
    public ResponseEntity<?> returnBook(@RequestBody ReturnRequest request) {
        return libraryService.returnBook(request)
                .map(book -> ResponseEntity.ok("Book returned: " + book.getTitle()))
                .orElse(ResponseEntity.badRequest().body("Book was not borrowed or not found."));
    }

    // 🧾 View all borrow records
    @GetMapping("/records")
    public ResponseEntity<List<BorrowRecord>> getAllBorrowRecords() {
        return ResponseEntity.ok(libraryService.getAllBorrowRecords());
    }

    // 🧾 View borrow records by borrower name
    @GetMapping("/records/{borrower}")
    public ResponseEntity<List<BorrowRecord>> getRecordsByBorrower(@PathVariable String borrower) {
        return ResponseEntity.ok(libraryService.getRecordsByBorrower(borrower));
    }
}