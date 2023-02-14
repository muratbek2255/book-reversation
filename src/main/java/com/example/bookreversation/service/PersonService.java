package com.example.bookreversation.service;

import com.example.bookreversation.dto.requests.PersonRequest;
import com.example.bookreversation.entity.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {
    public List<Person> getAllBook();

    public Person getById(int id);

    public String addPerson(PersonRequest personRequest);

    public String updatePerson(PersonRequest personRequest, int id);

    public String deletePerson(int id);
}
