package com.wsb.library2.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "isbn", nullable = false)
    private Long isbn;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
    private List<Loan> loans = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("{book id: %s, book title: %s, book author: %s, isbn: %s}",
                bookId, title, author, isbn);
    }

    public boolean isBorrowed() {
        if (this.getLoans() == null || this.getLoans().isEmpty()) {
            return false;
        }
        return this.getLoans().stream().anyMatch(x -> x.getReturnDate() == null);
    }

}