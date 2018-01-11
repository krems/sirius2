package com.sirius.singleton;

public class ThreadSafeLazySingleton {
    private static class Helper {
        private static final ThreadSafeLazySingleton instance = new ThreadSafeLazySingleton();
    }
    
    public static ThreadSafeLazySingleton instance() {
        return Helper.instance;
    }
}
