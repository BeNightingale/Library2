package com.wsb.library.repository;

import com.wsb.library.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanCrudRepository extends JpaRepository<Loan, Integer> {

    @Query("FROM Loan ORDER BY loanDate")
    List<Loan> getAllOrderByLoanDate();
}
