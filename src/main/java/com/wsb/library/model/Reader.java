package com.wsb.library.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "readers")
public class Reader implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reader_id")
    private int readerId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "telephone_number")
    private String telephoneNumber;
    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;
    @Column(name = "resignation_date")
    private LocalDate resignationDate;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "reader")
    private List<Loan> loans = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("{reader id: %s, first name: %s, last name: %s, address: %s, telephone number: %s," +
                        " registration date: %s, resignation date: %s}",
                readerId, firstName, lastName, address, telephoneNumber, registrationDate, resignationDate);
    }

    public List<Loan> getNotReturnedBooks() {
        if (loans == null) {
            return List.of();
        } else {
            return getLoans().stream()
                    .filter(loan -> loan.getReturnDate() == null)
                    .collect(Collectors.toList());
        }
    }

    public boolean hasReturnedBooks() {
        return this.getNotReturnedBooks() == null || this.getNotReturnedBooks().size() == 0;
    }
}