package com.example.bookreversation.service;

import com.example.bookreversation.dto.requests.BookRequest;
import com.example.bookreversation.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    public ResponseEntity<List<Book>> getAllBook();

    public ResponseEntity<String> getByIdBook(int id);

    public ResponseEntity<String> addBook(BookRequest bookRequest);

    public ResponseEntity<String> updateBook(BookRequest bookRequest, int id);

    public ResponseEntity<String> deleteBook(int id);
}
