package com.wsb.library2;

import com.wsb.library2.service.BookService;
import com.wsb.library2.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationController {

    @Autowired
    private BookService bookService;
    @Autowired
    private ReaderService readerService;

    @GetMapping("/book")
    public String showBookById(ModelMap model, @RequestParam(name = "id") Integer id) {
        model.addAttribute("book", bookService.getBook(id).orElseThrow());
        return "book";
    }

    @GetMapping("/book/find")
    public String findBookForm() {
        return "findBook";
    }

    @GetMapping("/book/find/title")
    public String findBookByTitle(ModelMap model, @RequestParam(name = "title") String title) {
        model.addAttribute("books", bookService.findBooksByTitle(title));
        return "bookList";
    }
    @PostMapping("/book/delete")
    public String deleteBook(@RequestParam("id") Integer id) {
        bookService.deleteBook(id);
        return "operationSuccess";
    }
    @GetMapping("/book/add")
    public String addBookForm() {
        return "addBook";
    }

    @PostMapping("/add/success")
    public String addBook(ModelMap model,
                          @RequestParam(name = "title") String title,
                          @RequestParam(name = "author") String author,
                          @RequestParam(name = "isbn") Long isbn) {
        model.addAttribute(
                "book",
                bookService.addBook(title, author, isbn));
        return "operationSuccess";
    }

    @GetMapping("/reader/find")
    public String findReaderForm() {
        return "findReader";
    }
    @GetMapping("/reader")
    public String showReaderById(ModelMap model, @RequestParam(name = "id") Integer id) {
        model.addAttribute("reader", readerService.getReader(id).orElseThrow());
        return "reader";
    }

    @GetMapping("/reader/find/name")
    public  String findReadersByFullName(ModelMap model,
                                         @RequestParam(name = "firstName") String firstName,
                                         @RequestParam(name = "lastName") String lastName) {
        model.addAttribute(
                "readers",
                readerService.findReadersByFullName(firstName, lastName));
        return "readerList";
    }

    @GetMapping("/")
    public String root() {
        return "root";
    }
}
