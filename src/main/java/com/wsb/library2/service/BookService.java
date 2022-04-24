package com.wsb.library2.service;

import com.wsb.library2.model.Book;
import com.wsb.library2.repository.BookCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookCrudRepository bookCrudRepository;

    public Book addBook(String title, String author, Long isbn) {
        Book book = Book.builder()
                .title(title)
                .author(author)
                .isbn(isbn)
                .build();
        return bookCrudRepository.save(book);
    }

    public void deleteBook(int bookId) {
        bookCrudRepository.deleteById(bookId);
    }

    public List<Book> getBooks() {
        return bookCrudRepository.findAll();
    }

    public Optional<Book> getBook(int bookId) {
        return bookCrudRepository.findById(bookId);
    }

    public Optional<Book> updateBook(int bookId, String title, String author, Long isbn) {
        Book book = Book.builder()
                .bookId(bookId)
                .title(title)
                .author(author)
                .isbn(isbn)
                .build();
        return bookCrudRepository.findById(bookId).map(savedBook -> bookCrudRepository.save(book));
    }


}