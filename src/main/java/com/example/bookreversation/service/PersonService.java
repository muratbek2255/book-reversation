package com.example.bookreversation.service;

import com.example.bookreversation.dto.requests.PersonRequest;
import com.example.bookreversation.entity.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {
    public ResponseEntity<List<Person>> getAllBook();

    public ResponseEntity<Person> getById(int id);

    public ResponseEntity<String> addPerson(PersonRequest personRequest);

    public ResponseEntity<String> updatePerson(PersonRequest personRequest, int id);

    public ResponseEntity<String> deletePerson(int id);
}
