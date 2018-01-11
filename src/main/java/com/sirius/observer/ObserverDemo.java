package com.sirius.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        Publisher observable = new Publisher();
        observable.subscribe(o -> System.out.println("First: " + o));
        observable.subscribe(o -> System.out.println("Second: " + o));
        observable.subscribe(o -> System.out.println("Third: " + o));
        
        observable.publish();
    }
}
