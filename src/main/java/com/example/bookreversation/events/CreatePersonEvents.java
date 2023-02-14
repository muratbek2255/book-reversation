package com.example.bookreversation.events;

import org.springframework.context.ApplicationEvent;

public class CreatePersonEvents extends ApplicationEvent {
    public String payload;

    public CreatePersonEvents(Object source, String payload) {
        super(source);
        this.payload = payload;
    }
}
