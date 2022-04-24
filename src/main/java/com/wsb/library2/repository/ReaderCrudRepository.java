package com.wsb.library2.repository;

import com.wsb.library2.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface ReaderCrudRepository extends JpaRepository<Reader, Integer>{

    @Query("FROM Reader ORDER BY readerId")
    List<Reader> getAllOrderById();

    @Query("FROM Reader ORDER BY lastName")
    List<Reader> getAllOrderByLastName();

    @Query("FROM Reader WHERE firstName = :firstName AND lastName = :lastName ORDER BY readerId")
    List<Reader> findAllByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}




