package com.sirius.excercise;

import java.util.concurrent.Callable;

public class NamingCallableDecorator<T> implements Callable<T> {
    private final Callable<T> wrapped;
    
    NamingCallableDecorator(final Callable<T> wrapped) {
        this.wrapped = wrapped;
    }
    
    @Override
    public T call() throws Exception {
        final String oldName = Thread.currentThread().getName();
        Thread.currentThread().setName(wrapped.getClass().getName());
        final T result;
        try {
            result = wrapped.call();
        } finally {
            Thread.currentThread().setName(oldName);
        }
        return result;
    }
}
