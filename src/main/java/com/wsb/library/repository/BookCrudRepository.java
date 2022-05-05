package com.wsb.library.repository;

import com.wsb.library.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface BookCrudRepository extends JpaRepository<Book, Integer> {

    @Query("FROM Book ORDER BY title")
    List<Book> getAllOrderByTitle();

    @Query("FROM Book WHERE title LIKE %:title% ORDER BY author")
    List<Book> findBooksByTitle(@Param("title") String title);
}
