package com.wsb.library2;

import com.wsb.library2.exception.ResourceNotFoundException;
import com.wsb.library2.service.BookService;
import com.wsb.library2.service.LoanService;
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
    @Autowired
    private LoanService loanService;

    @GetMapping("/book")
    public String showBookById(ModelMap model, @RequestParam(name = "id") Integer id) {
        model.addAttribute("book",
                bookService.getBook(id).orElseThrow(ResourceNotFoundException::new));
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

    @GetMapping("book/find/all")
    public String getAllBooks(ModelMap model) {
        model.addAttribute("books", bookService.getBooks());
        return "bookList";
    }

    @PostMapping("/book/delete")
    public String deleteBook(@RequestParam(name = "id") Integer id) {
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

    @PostMapping("/book/return")
    public String returnBook(@RequestParam(name = "id") Integer id) {
        bookService.returnBook(id);
        return "operationSuccess";
    }

    @GetMapping("book/update")
    public String updateBookForm(ModelMap model,
                                 @RequestParam(name = "bookId") Integer bookId) {
        model.addAttribute("book",
                bookService.getBook(bookId).orElseThrow(ResourceNotFoundException::new));
        return "updateBookData";
    }

    @PostMapping("/book/update/data")
    public String updateBook(ModelMap model,
                             @RequestParam(name = "bookId") Integer bookId,
                             @RequestParam(name = "title") String title,
                             @RequestParam(name = "author") String author,
                             @RequestParam(name = "isbn") Long isbn) {
        model.addAttribute(
                "book",
                bookService.updateBook(bookId, title, author, isbn));
        return "operationSuccess";
    }

    @GetMapping("/reader/find")
    public String findReaderForm() {
        return "findReader";
    }

    @GetMapping("/reader")
    public String showReaderById(ModelMap model, @RequestParam(name = "id") Integer id) {
        model.addAttribute(
                "reader",
                readerService.getReader(id).orElseThrow(ResourceNotFoundException::new));
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

    @GetMapping("reader/find/all")
    public String getAllReadersByLastName(ModelMap model) {
        model.addAttribute("readers", readerService.getAllReaders());
        return "readerList";
    }

    @GetMapping("/reader/add")
    public String addReaderForm() {
        return "addReader";
    }

    @PostMapping("/reader/add")
    public String addReader(ModelMap model,
                            @RequestParam(name = "firstName") String firstName,
                            @RequestParam(name = "lastName") String lastName,
                            @RequestParam(name = "address") String address,
                            @RequestParam(name = "telephoneNumber") String telephoneNumber) {
        model.addAttribute(
                "reader",
                readerService.addReader(firstName, lastName, address, telephoneNumber));
        return "operationSuccess";
    }

    @PostMapping("/reader/resign")
    public String registerReaderResignation(@RequestParam(name = "readerId") Integer readerId) {
        readerService.registerResignation(readerId);
        return "operationSuccess";
    }

    @GetMapping("reader/update")
    public String updateReaderForm(ModelMap model,
                                 @RequestParam(name = "readerId") Integer readerId) {
        model.addAttribute("reader",
                readerService.getReader(readerId).orElseThrow(ResourceNotFoundException::new));
        return "updateReaderData";
    }

    @PostMapping("/reader/update/data")
    public String updateReader(ModelMap model,
                               @RequestParam(name = "readerId") Integer readerId,
                               @RequestParam(name = "firstName") String firstName,
                               @RequestParam(name = "lastName") String lastName,
                               @RequestParam(name = "address") String address,
                               @RequestParam(name = "telephoneNumber") String telephoneNumber) {
        model.addAttribute(
                "reader",
                readerService.updateReader(readerId, firstName, lastName, address, telephoneNumber));
        return "operationSuccess";
    }

    @GetMapping("/loan/add")
    public String addLoanForm() {
        return "addLoan";
    }

    @PostMapping("/loan/add")
    public String addLoan(ModelMap model,
                          @RequestParam(name = "bookId") Integer bookId,
                          @RequestParam(name = "readerId") Integer readerId) {
        model.addAttribute(
                "loan",
                loanService.addLoan(
                        bookService.getBook(bookId).orElseThrow(ResourceNotFoundException::new),
                        readerService.getReader(readerId).orElseThrow(ResourceNotFoundException::new)));
        return "operationSuccess";
    }

    @GetMapping("loan/find/all")
    public String getAllLoans(ModelMap model) {
        model.addAttribute("loans", loanService.getLoans());
        return "loanList";
    }

    @GetMapping("/")
    public String root() {
        return "root";
    }
}
