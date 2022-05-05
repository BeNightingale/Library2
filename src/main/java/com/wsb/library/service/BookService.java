package com.wsb.library.service;

import com.wsb.library.exception.ResourceNotFoundException;
import com.wsb.library.model.Book;
import com.wsb.library.model.Loan;
import com.wsb.library.repository.BookCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
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
        return bookCrudRepository.getAllOrderByTitle();
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

    public List<Book> findBooksByTitle(String title) {
        return bookCrudRepository.findBooksByTitle(title);
    }

    public void returnBook(int bookId) {
        Book book = bookCrudRepository.getById(bookId);
        if (book.isBorrowed()) {
            Optional<Loan> loan = book.getLoans()
                    .stream()
                    .filter(l -> l.getReturnDate() == null)
                    .findFirst();
            loan.orElseThrow(ResourceNotFoundException::new).setReturnDate(LocalDate.now());
            bookCrudRepository.save(book);
        }
    }
}
