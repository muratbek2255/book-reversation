package com.example.bookreversation.events;

import org.springframework.context.ApplicationEvent;

public class CreateBookEvents extends ApplicationEvent {
    public String payload;

    public CreateBookEvents(Object source, String payload) {
        super(source);
        this.payload = payload;
    }
}
