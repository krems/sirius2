package com.sirius.excercise;

import java.util.concurrent.Callable;

class CatchingCallableDecorator<T> implements Callable<T> {
    private final Callable<T> wrapped;
    
    CatchingCallableDecorator(final Callable<T> wrapped) {
        this.wrapped = wrapped;
    }
    
    @Override
    public T call() throws Exception {
        try {
            return wrapped.call();
        } catch (Throwable e) {
            System.err.println("Oops! " + e.getMessage());
            throw e;
        }
    }
}
