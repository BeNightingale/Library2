package com.wsb.library2;

import com.wsb.library2.service.BookService;
import com.wsb.library2.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationController {

    @Autowired
    private BookService bookService;
    @Autowired
    private ReaderService readerService;

    @GetMapping("/book")
    public String book(ModelMap model, @RequestParam(name = "id") Integer id) {
        model.addAttribute("book", bookService.getBook(id).orElseThrow());
        return "book";
    }

    @GetMapping("/book/find")
    public String findBook() {
        return "findBook";
    }

    @GetMapping("/reader")
    public String reader(ModelMap model, @RequestParam(name = "id") Integer id) {
        model.addAttribute("reader", readerService.getReader(id).orElseThrow());
        return "reader";
    }

    @GetMapping("/reader/find")
    public String findReader() {
        return "findReader";
    }

    @GetMapping("/book/delete")
    public String deleteBook(@RequestParam("id") Integer id) {
        bookService.deleteBook(id);
        return "deletedBook";
    }

    @GetMapping("/")
    public String root() {
        return "root";
    }
}
