package com.example.bookreversation.repository;

import com.example.bookreversation.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT * FROM book_kg.books WHERE book_kg.books.id = ?1", nativeQuery = true)
    Book getById(@Param("id") int id);
}
