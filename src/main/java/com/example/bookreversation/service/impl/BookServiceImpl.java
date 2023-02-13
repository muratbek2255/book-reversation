package com.example.bookreversation.service.impl;

import com.example.bookreversation.dto.requests.BookRequest;
import com.example.bookreversation.entity.Book;
import com.example.bookreversation.entity.Person;
import com.example.bookreversation.repository.BookRepository;
import com.example.bookreversation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final PersonServiceImpl personService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, PersonServiceImpl personService) {
        this.bookRepository = bookRepository;
        this.personService = personService;
    }

    @Override
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> book = bookRepository.findAll();
        return ResponseEntity.status(200).body(book);
    }

    @Override
    public ResponseEntity<String> getByIdBook(int id) {
        Book book = (Book) bookRepository.getById(id);

        if(book.getPerson() == null) {
            return ResponseEntity.status(200).body("Эта книга свободна");
        }

        return ResponseEntity.status(200).body("Эта книга не свободна, она занята вот этим user:" +
                book.getPerson().toString());
    }

    @Override
    public ResponseEntity<String> addBook(BookRequest bookRequest) {
        Book book = new Book();

        Person person = personService.getById(bookRequest.getPerson().getId()).getBody();

        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setYear(bookRequest.getYear());
        book.setPerson(person);

        bookRepository.save(book);

        return ResponseEntity.status(201).body("Book created!");
    }

    @Override
    public ResponseEntity<String> updateBook(BookRequest bookRequest, int id) {
        Book book = new Book();

        Person person = personService.getById(bookRequest.getPerson().getId()).getBody();

        Book book1 = bookRepository.findById(id)
                .map(book2 -> {
                    book2.setTitle(bookRequest.getTitle());
                    book2.setAuthor(bookRequest.getAuthor());
                    book2.setYear(bookRequest.getYear());
                    book2.setPerson(person);
                    return bookRepository.save(book2);
                })
                .orElseGet(() -> {
                    book.setId(bookRequest.getId());
                    return bookRepository.save(book);
                });

        return ResponseEntity.status(201).body("Updated book!");
    }

    @Override
    public ResponseEntity<String> deleteBook(int id) {
        bookRepository.deleteById(id);

        return ResponseEntity.status(202).body("Deleted Book!");
    }
}
