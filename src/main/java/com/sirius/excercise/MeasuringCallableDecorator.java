package com.sirius.excercise;

import java.util.concurrent.Callable;

class MeasuringCallableDecorator<T> implements Callable<T> {
    private final Callable<T> wrapped;
    
    MeasuringCallableDecorator(final Callable<T> wrapped) {
        this.wrapped = wrapped;
    }
    
    @Override
    public T call() throws Exception {
        final long start = System.currentTimeMillis();
        final T result;
        try {
            result = wrapped.call();
        } finally {
            final long duration = System.currentTimeMillis() - start;
            System.out.println(duration);
        }
        return result;
    }
}
