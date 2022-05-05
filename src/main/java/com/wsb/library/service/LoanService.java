package com.wsb.library.service;

import com.wsb.library.exception.ResourceNotFoundException;
import com.wsb.library.exception.ResourceUnavailable;
import com.wsb.library.model.Book;
import com.wsb.library.model.Loan;
import com.wsb.library.model.Reader;
import com.wsb.library.repository.LoanCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

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

    public List<Loan> getLoans() {
        return loanCrudRepository.getAllOrderByLoanDate();
    }
}