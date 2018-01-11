package com.sirius.singleton;

public class SingletonField {
    public static final SingletonField instance = new SingletonField();
    
    private SingletonField() {}
}
