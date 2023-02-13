package com.example.bookreversation.controller;

import com.example.bookreversation.dto.requests.JoinRequest;
import com.example.bookreversation.dto.requests.PersonRequest;
import com.example.bookreversation.entity.Person;
import com.example.bookreversation.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServiceImpl personService;

    @Autowired
    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson() {
        return personService.getAllBook();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable int id) {
        return ResponseEntity.status(200).body(personService.getById(id).getBody());
    }

    @PostMapping
    public ResponseEntity<String> addPerson(@RequestBody PersonRequest personRequest) {
        return personService.addPerson(personRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@RequestBody PersonRequest personRequest,
                                               @PathVariable int id) {
        return personService.updatePerson(personRequest, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        return personService.deletePerson(id);
    }

    @GetMapping("/get-book-by-person-id/{id}")
    public ResponseEntity<String> getBookByPersonId(@PathVariable int id) {
        return personService.getBookByPersonId(id);
    }
}
