package com.codewithudo.bookinventoryapi.service;

import com.codewithudo.bookinventoryapi.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {

    private final ArrayList<Book> books = new ArrayList<>();
    private int nextId = 1;

    public ArrayList<Book> addBook(Book book) {
        books.add(book);
        book.setId(nextId++);
        return books;
    }

    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
//        return books.stream()
//                .filter(book -> book.getId().equals(id))
//                .findFirst()
//                .orElse(null);

    }

    public boolean updateBook(int id, Book updatedBook) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setIsbn(updatedBook.getIsbn());
                book.setPrice(updatedBook.getPrice());
                return true;
            }
        }
        return false;
    }

    public boolean deleteBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                return true;
            }
        }
        return false;
//        return books.removeIf(book -> book.getId().equals(id));
    }
}
