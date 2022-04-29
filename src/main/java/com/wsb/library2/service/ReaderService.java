package com.wsb.library2.service;

import com.wsb.library2.exception.ResourceNotFoundException;
import com.wsb.library2.model.Reader;
import com.wsb.library2.repository.ReaderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReaderService {

    @Autowired
    private ReaderCrudRepository readerCrudRepository;

    public Reader addReader(String firstName, String lastName, String address,
                            String telephoneNumber) {
        Reader reader = Reader.builder()
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .telephoneNumber(telephoneNumber)
                .registrationDate(LocalDate.now())
                .build();
        return readerCrudRepository.save(reader);
    }

    public Optional<Reader> getReader(int readerId) {
        return readerCrudRepository.findById(readerId);
    }

    public List<Reader> findReadersByFullName(String firstName, String lastName) {
        return readerCrudRepository.findAllByFullName(firstName, lastName);
    }

    public List<Reader> getAllReaders() {
        return readerCrudRepository.getAllOrderByLastName();
    }

    public void registerResignation(int readerId) {
        Reader reader = getReader(readerId).orElseThrow(ResourceNotFoundException::new);
        if (reader.getResignationDate() == null) {
            reader.setResignationDate(LocalDate.now());
        }
        readerCrudRepository.save(reader);
    }
}
