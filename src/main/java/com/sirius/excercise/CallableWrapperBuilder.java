package com.sirius.excercise;

import java.util.concurrent.Callable;

class CallableWrapperBuilder<T> {
    private final Callable<T> task;
    private boolean useMeasurer;
    private boolean useCatcher;
    private boolean useNamer;
    
    private CallableWrapperBuilder(final Callable<T> task) {
        this.task = task;
    }
    
    public static <T> CallableWrapperBuilder of(final Callable<T> task) {
        return new CallableWrapperBuilder<T>(task);
    }
    
    public CallableWrapperBuilder measuring(final boolean measuring) {
        useMeasurer = measuring;
        return this;
    }
    
    public CallableWrapperBuilder catching(final boolean catching) {
        useCatcher = catching;
        return this;
    }
    
    public CallableWrapperBuilder naming(final boolean naming) {
        useNamer = naming;
        return this;
    }
    
    public Callable<T> build() {
        Callable<T> wrapped = this.task;
        if (useNamer) {
            wrapped = new NamingCallableDecorator<>(wrapped);
        }
        if (useMeasurer) {
            wrapped = new MeasuringCallableDecorator<>(wrapped);
        }
        if (useCatcher) {
            wrapped = new CatchingCallableDecorator<>(wrapped);
        }
        return wrapped;
    }
}
