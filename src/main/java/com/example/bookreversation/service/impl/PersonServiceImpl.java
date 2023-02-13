package com.example.bookreversation.service.impl;

import com.example.bookreversation.dto.requests.JoinRequest;
import com.example.bookreversation.dto.requests.PersonRequest;
import com.example.bookreversation.entity.Person;
import com.example.bookreversation.repository.PersonRepository;
import com.example.bookreversation.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public ResponseEntity<List<Person>> getAllBook() {
        List<Person> people = personRepository.findAll();
        return ResponseEntity.status(200).body(people);
    }

    @Override
    public ResponseEntity<Person> getById(int id) {
        Person person = (Person) personRepository.getById(id);

        if(person.getBooks().isEmpty()) {
            return null;
        }

        return ResponseEntity.status(200).body(person);
    }

    @Override
    public ResponseEntity<String> addPerson(PersonRequest personRequest) {
        Person person = new Person();

        person.setFirstName(personRequest.getFirstName());
        person.setLastName(personRequest.getLastName());
        person.setDateBirthday(personRequest.getDateBirthday());

        personRepository.save(person);

        return ResponseEntity.status(201).body("Person Created");
    }

    @Override
    public ResponseEntity<String> updatePerson(PersonRequest personRequest, int id) {
        Person person2 = new Person();

        Person person = personRepository.findById(id)
                .map(person1 -> {
                    person1.setFirstName(personRequest.getFirstName());
                    person1.setLastName(personRequest.getLastName());
                    person1.setDateBirthday(personRequest.getDateBirthday());
                    return personRepository.save(person1);
                })
                .orElseGet(() -> {
                    person2.setId(personRequest.getId());
                    return personRepository.save(person2);
                });

        return ResponseEntity.status(201).body("Updated person!");
    }

    @Override
    public ResponseEntity<String> deletePerson(int id) {
        personRepository.deleteById(id);

        return ResponseEntity.status(202).body("Delete person!");
    }

    public ResponseEntity<String> getBookByPersonId(int id) {
        JoinRequest personId = (personRepository.getBookByPersonId(id));
        return ResponseEntity.status(200).body(personId.toString());
    }
}
