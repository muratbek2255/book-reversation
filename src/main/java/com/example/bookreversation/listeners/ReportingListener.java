package com.example.bookreversation.listeners;

import com.example.bookreversation.events.CreateBookEvents;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReportingListener {

    @EventListener(CreateBookEvents.class)
    public void reportUserCreation(CreateBookEvents event) {
        System.out.println("Increment counter as new book was created: " + event);
    }

    @EventListener(CreateBookEvents.class)
    public void syncUserToExternalSystem(CreateBookEvents event) {
        System.out.println("informing other systems about book user: " + event);
    }
}
