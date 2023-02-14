package com.example.bookreversation.listeners;

import com.example.bookreversation.events.CreateBookEvents;
import com.example.bookreversation.events.CreatePersonEvents;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReportingPersonListener {

    @EventListener(CreatePersonEvents.class)
    public void reportUserCreation(CreateBookEvents event) {
        System.out.println("Increment counter as new book was created: " + event);
    }

    @EventListener(CreatePersonEvents.class)
    public void syncUserToExternalSystem(CreateBookEvents event) {
        System.out.println("informing other systems about book user: " + event);
    }
}
