package com.example.bookreversation.service.impl;

import com.example.bookreversation.dto.requests.BookRequest;
import com.example.bookreversation.dto.requests.JoinRequest;
import com.example.bookreversation.entity.Book;
import com.example.bookreversation.entity.Person;
import com.example.bookreversation.events.CreateBookEvents;
import com.example.bookreversation.repository.BookRepository;
import com.example.bookreversation.service.BookService;;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final PersonServiceImpl personService;
    private ApplicationEventPublisher eventPublisher;
    Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, PersonServiceImpl personService, ApplicationEventPublisher eventPublisher) {
        this.bookRepository = bookRepository;
        this.personService = personService;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> book = bookRepository.findAll();
        return book;
    }

    @Override
    public String getByIdBook(int id) {
        Book book = (Book) bookRepository.getById(id);

        if(book.getPerson() == null) {
            return "Эта книга свободна";
        }

        return "Эта книга не свободна, она занята вот этим user:" + book.getPerson().toString();
    }

    @Override
    public String addBook(BookRequest bookRequest) {
        Book book = new Book();

        Person person = personService.getById(bookRequest.getPerson().getId());

        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setYear(bookRequest.getYear());
        book.setPerson(person);
        book.setTakenAt(bookRequest.getTaken_at());
        book.setExpired(Boolean.FALSE);

        bookRepository.save(book);

        CreateBookEvents publisher = new CreateBookEvents(
                this,
                "Add in DB and CREATE Book!"
        );
        eventPublisher.publishEvent(publisher);

        return "Book created!";
    }

    @Override
    public String updateBook(BookRequest bookRequest, int id) {
        Book book = new Book();

        Person person = personService.getById(bookRequest.getPerson().getId());

        Book book1 = bookRepository.findById(id)
                .map(book2 -> {
                    book2.setTitle(bookRequest.getTitle());
                    book2.setAuthor(bookRequest.getAuthor());
                    book2.setYear(bookRequest.getYear());
                    book2.setPerson(person);
                    book2.setTakenAt(bookRequest.getTaken_at());
                    book2.setExpired(Boolean.FALSE);
                    return bookRepository.save(book2);
                })
                .orElseGet(() -> {
                    book.setId(bookRequest.getId());
                    return bookRepository.save(book);
                });

        return "Updated book!";
    }

    @Override
    public String deleteBook(int id) {
        bookRepository.deleteById(id);

        return "Deleted Book!";
    }

    public String getBookByPersonId(int id) {
        JoinRequest personId = (bookRepository.getBookByPersonId(id));
        return personId.toString();
    }

    @Scheduled(initialDelay = 1000L, fixedDelay = 3000L)
    public void someMethod() {
        System.out.println("Hello world");
    }
}
