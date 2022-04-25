package com.wsb.library2.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "book_loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private int loanId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reader_id")
    private Reader reader;
    @Column(name = "loan_date", nullable = false)
    private LocalDate loanDate;
    @Column(name = "return_date")
    private LocalDate returnDate;

    @Override
    public String toString() {
        return String.format("{loan id: %s, book id: %s, reader id: %s, loan date: %s, return date: %s}",
                this.getLoanId(),
                this.getBook().getBookId(),
                this.getReader().getReaderId(),
                this.getLoanDate(),
                this.getReturnDate());
    }
}
