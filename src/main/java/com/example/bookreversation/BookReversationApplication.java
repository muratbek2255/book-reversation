package com.example.bookreversation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BookReversationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookReversationApplication.class, args);
    }

}
