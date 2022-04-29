package com.wsb.library2.service;

import com.wsb.library2.exception.ResourceNotFoundException;
import com.wsb.library2.exception.ResourceUnavailable;
import com.wsb.library2.model.Book;
import com.wsb.library2.model.Loan;
import com.wsb.library2.model.Reader;
import com.wsb.library2.repository.LoanCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanService {
    @Autowired
    private LoanCrudRepository loanCrudRepository;

    public Loan addLoan(Book book, Reader reader) {
        if (book.isBorrowed()) {
            throw new ResourceUnavailable();
        }
        if (reader.getResignationDate() != null) {
            throw new ResourceNotFoundException();
        }
        Loan loan = Loan.builder()
                .book(book)
                .reader(reader)
                .loanDate(LocalDate.now())
                .build();
        return loanCrudRepository.save(loan);
    }
}