package com.example.bookreversation.repository;

import com.example.bookreversation.dto.requests.JoinRequest;
import com.example.bookreversation.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT * FROM book_kg.books WHERE book_kg.books.id = ?1", nativeQuery = true)
    Book getById(@Param("id") int id);

    @Query(value = "SELECT new com.example.bookreversation.dto.requests.JoinRequest(j.id, j.title, j.author, j.year, j.person.firstName, j.person.lastName, j.person.dateBirthday) FROM Book j")
    JoinRequest getBookByPersonId(@Param("id") int personId);
}
