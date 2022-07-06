package com.wsb.library;

import com.wsb.library.model.Book;
import com.wsb.library.model.Reader;
import com.wsb.library.service.BookService;
import com.wsb.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ReaderService readerService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getABook(@PathVariable("bookId") int bookId) {
        return bookService.getBook(bookId).orElse(null);
    }

    @GetMapping("/books/title")
    public List<Book> getBooksByTitle(@RequestParam String title) {
        return bookService.findBooksByTitle(title);
    }

    @PostMapping("/book")
    public Book addABook(@RequestBody Book book) {
       return bookService.addBook(book.getTitle(),
                                book.getAuthor(),
                                book.getIsbn());
    }
    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable int bookId,
                               @RequestParam String title,
                               @RequestParam String author,
                               @RequestParam Long isbn) {
        return bookService.updateBook(bookId, title, author, isbn).orElse(null);
    }
    @PutMapping("/books/return/{bookId}")
    public String returnBook(@PathVariable int bookId) {
        if (bookService.getBook(bookId).get().isBorrowed()) {
            bookService.returnBook(bookId);
            return "Ok, returned!";
        } else {
            return "The book wasn't borrowed, it is available!";
        }
    }

    @PostMapping("/reader/arg")
    public Reader addAReader1(@RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam String address,
                            @RequestParam String telephoneNumber) {
        return readerService.addReader(firstName, lastName, address, telephoneNumber);
    }
    @PostMapping("/reader")
    public Reader addAReader(@RequestBody Reader reader) {
        return readerService.addReader(reader.getFirstName(),
                                    reader.getLastName(),
                                    reader.getAddress(),
                                    reader.getTelephoneNumber());
    }

    @GetMapping("/readers")
    public List<Reader> getAllReaders() {
        return readerService.getAllReaders();
    }
    @GetMapping("/readers/{readerId}")
    public Reader getAReader(@PathVariable("readerId") int readerId) {
        return readerService.getReader(readerId).orElse(null);
    }

    @PutMapping("/readers/{readerId}")
    public Reader updateReader(@PathVariable int readerId,
                               @RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String address,
                               @RequestParam String telephoneNumber) {
        return readerService.updateReader(readerId,
                                firstName,
                                lastName,
                                address,
                                telephoneNumber);
    }

    @PutMapping("/readers/resignation/{readerId}")
    public String resign(@PathVariable int readerId) {
        if (readerService.getReader(readerId).isPresent() &&
            readerService.getReader(readerId).get().getResignationDate() == null) {
            readerService.registerResignation(readerId);
            return "Resignation saved!";
        }
        return "That reader resigned earlier!";
    }

   @GetMapping("/welcome")
   public String greet() {
        return "Welcome in my library!";
   }
}
