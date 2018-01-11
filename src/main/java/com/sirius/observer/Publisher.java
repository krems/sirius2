package com.sirius.observer;

import java.util.Collection;
import java.util.HashSet;

public class Publisher {
    private final Collection<Subscriber<Publisher>> subscribers = new HashSet<>();
    
    public void subscribe(Subscriber<Publisher> subscriber) {
        subscribers.add(subscriber);
    }
    
    public void publish() {
        for (Subscriber<Publisher> subscriber : subscribers) {
            subscriber.update(this);
        }
    }
}
