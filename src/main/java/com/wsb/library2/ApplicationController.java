package com.wsb.library2;

import com.wsb.library2.model.Book;
import com.wsb.library2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public String book(ModelMap model, @RequestParam(name = "id") Integer id)
    {
        model.addAttribute("book", bookService.getBook(id).orElseThrow());
        return "book";
    }

    @GetMapping("/book/find")
    public String findBook() {
        return "findBook";
    }

    @GetMapping("/")
    public String root()
    {
        return "root";
    }

}
