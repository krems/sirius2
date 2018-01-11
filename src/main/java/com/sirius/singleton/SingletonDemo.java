package com.sirius.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println(SingletonFabric.instance());
        System.out.println(SingletonFabric.instance() == SingletonFabric.instance());
        System.out.println(SingletonField.instance);
        System.out.println(SingletonField.instance == SingletonField.instance);
        System.out.println(ThreadSafeSingleton.instance());
        System.out.println(ThreadSafeSingleton.instance() == ThreadSafeSingleton.instance());
        System.out.println(ThreadSafeLazySingleton.instance());
        System.out.println(ThreadSafeLazySingleton.instance() == ThreadSafeLazySingleton.instance());
    }
}
