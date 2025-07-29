package com.codewithudo.elibrarybooklending.service;

import com.codewithudo.elibrarybooklending.dto.BorrowRequest;
import com.codewithudo.elibrarybooklending.dto.ReturnRequest;
import com.codewithudo.elibrarybooklending.model.Book;
import com.codewithudo.elibrarybooklending.model.BorrowRecord;
import com.codewithudo.elibrarybooklending.repository.BookRepository;
import com.codewithudo.elibrarybooklending.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> borrowBook(BorrowRequest request) {
        Optional<Book> optionalBook = bookRepository.findById(request.getBookId());

        if (optionalBook.isEmpty()) return Optional.empty();

        Book book = optionalBook.get();

        if (book.isBorrowed()) return Optional.empty(); // already borrowed

        book.setBorrowed(true);
        bookRepository.save(book);

        BorrowRecord record = new BorrowRecord();
        record.setBook(book);
        record.setBorrowerName(request.getBorrowerName());
        record.setBorrowedDate(LocalDateTime.now());
        borrowRecordRepository.save(record);

        return Optional.of(book);
    }

    public Optional<Book> returnBook(ReturnRequest request) {
        Optional<Book> optionalBook = bookRepository.findById(request.getBookId());

        if (optionalBook.isEmpty()) return Optional.empty();

        Book book = optionalBook.get();

        if (!book.isBorrowed()) return Optional.empty(); // not currently borrowed

        book.setBorrowed(false);
        bookRepository.save(book);

        return Optional.of(book);
    }

    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }

    public List<BorrowRecord> getRecordsByBorrower(String borrowerName) {
        return borrowRecordRepository.findByBorrowerName(borrowerName);
    }
}