package com.wsb.library2;

import com.wsb.library2.model.Book;
import com.wsb.library2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ApplicationController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/{id}")
    public String book(ModelMap model, @PathVariable("id") Integer id)
    {
        model.addAttribute("book", bookService.getBook(id).orElseThrow());
        return "book";
    }

    @GetMapping("/")
    public String root()
    {
        return "root";
    }

}
