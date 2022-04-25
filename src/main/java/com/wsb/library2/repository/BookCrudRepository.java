package com.wsb.library2.repository;

import com.wsb.library2.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface BookCrudRepository extends JpaRepository<Book, Integer> {

    @Query("FROM Book ORDER BY bookId")
    List<Book> getAllOrderById();

    @Query("FROM Book ORDER BY title")
    List<Book> getAllOrderByTitle();

    @Query("FROM Book ORDER BY author")
    List<Book> getAllOrderByAuthor();

    @Query("FROM Book WHERE title LIKE %:title% ORDER BY author")
    List<Book> findBooksByTitle(@Param("title") String title);

    @Query("FROM Book WHERE author = :author ORDER BY title")
    List<Book> findBooksByAuthor(@Param("author") String author);

    @Query("FROM Book WHERE isbn = :isbn ORDER BY bookId")
    List<Book> findBooksByIsbn(@Param("isbn") Long isbn);

    @Query("FROM Book WHERE title = :title AND author = :author ORDER BY bookId")
    List<Book> findBooksByTitleAndAuthor(@Param("title") String title, @Param("author") String author);
}
