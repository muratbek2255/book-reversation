package com.example.bookreversation.service;

import com.example.bookreversation.dto.requests.BookRequest;
import com.example.bookreversation.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    public List<Book> getAllBook();

    public String getByIdBook(int id);

    public String addBook(BookRequest bookRequest);

    public String updateBook(BookRequest bookRequest, int id);

    public String deleteBook(int id);
}
