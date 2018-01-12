package com.sirius.excercise;

import java.util.concurrent.Callable;

public class MeasuringCallableDecorator<T> implements Callable<T> {
    private final Callable<T> wrapped;
    
    public MeasuringCallableDecorator(final Callable<T> wrapped) {
        this.wrapped = wrapped;
    }
    
    @Override
    public T call() throws Exception {
        final long start = System.currentTimeMillis();
        final T result;
        try {
            result = wrapped.call();
        } finally {
            System.out.println(System.currentTimeMillis() - start);
        }
        return result;
    }
}
