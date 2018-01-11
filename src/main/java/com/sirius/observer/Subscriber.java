package com.sirius.observer;

public interface Subscriber<T> {
    void update(T observed);
}
