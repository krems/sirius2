package com.sirius.singleton;

public class SingletonFabric {
    private static SingletonFabric instance;
    
    private SingletonFabric() {}
    
    public static SingletonFabric instance() {
        if (instance == null) {
            instance = new SingletonFabric();
        }
        return instance;
    }
}
