package com.wsb.library2.repository;

import com.wsb.library2.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanCrudRepository extends JpaRepository<Loan, Integer> {

    @Query("FROM Loan ORDER BY loanDate")
    List<Loan> getAllOrderByLoanDate();
}
