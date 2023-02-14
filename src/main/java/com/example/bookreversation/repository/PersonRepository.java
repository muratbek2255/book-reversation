package com.example.bookreversation.repository;

import com.example.bookreversation.dto.requests.JoinRequest;
import com.example.bookreversation.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query(value = "SELECT * FROM book_kg.persons WHERE book_kg.persons.id = ?1", nativeQuery = true)
    Person getById(@Param("id") int id);
}
