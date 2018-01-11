package com.sirius.singleton;

public class DoubleCheckedLockingThreadSafeVeryBadSingletonWithLongName {
    // PLEASE DON'T DO THAT, USE INNER CLASS IF YOU SOOOO NEED LAZY THREADSAFE SINGLETON
    private static volatile DoubleCheckedLockingThreadSafeVeryBadSingletonWithLongName instance;
    
    public static DoubleCheckedLockingThreadSafeVeryBadSingletonWithLongName instance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingThreadSafeVeryBadSingletonWithLongName.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingThreadSafeVeryBadSingletonWithLongName();
                }
            }
        }
        return instance;
    }
}
