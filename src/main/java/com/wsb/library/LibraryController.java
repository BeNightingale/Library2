package com.wsb.library;

import com.wsb.library.model.Book;
import com.wsb.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    public Book getABook(@PathVariable int id) {
        return bookService.getBook(id).get();
    }
}
