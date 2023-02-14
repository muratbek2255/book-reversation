package com.example.bookreversation.controller;

import com.example.bookreversation.dto.requests.BookRequest;
import com.example.bookreversation.entity.Book;
import com.example.bookreversation.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {
    private final BookServiceImpl bookService;

    @Autowired
    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBook() {
        return ResponseEntity.status(200).body(bookService.getAllBook());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getByIdBook(@PathVariable int id) {
        return ResponseEntity.status(200).body(bookService.getByIdBook(id));
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody BookRequest bookRequest) {
        return ResponseEntity.status(201).body(bookService.addBook(bookRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@RequestBody BookRequest bookRequest,
                                             @PathVariable int id) {
        return ResponseEntity.status(201).body(bookService.updateBook(bookRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        return ResponseEntity.status(201).body(bookService.deleteBook(id));
    }

    @GetMapping("/get-book-by-person=-id/{id}")
    public ResponseEntity<String> getBookByPersonId(@PathVariable int id) {
        return ResponseEntity.status(202).body(bookService.getBookByPersonId(id));
    }
}
