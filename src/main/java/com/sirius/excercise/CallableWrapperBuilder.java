package com.sirius.excercise;

import java.util.concurrent.Callable;

public class CallableWrapperBuilder<T> {
    private Callable<T> task;
    private boolean useMeasurer;
    private boolean useCatcher;
    private boolean useNamer;
    
    public CallableWrapperBuilder<T> task(Callable<T> task) {
        this.task = task;
        return this;
    }
    
    public CallableWrapperBuilder measuring() {
        useMeasurer = true;
        return this;
    }
    
    public CallableWrapperBuilder catching() {
        useCatcher = true;
        return this;
    }
    
    public CallableWrapperBuilder naming() {
        useNamer = true;
        return this;
    }
    
    public Callable<T> build() {
        validate();
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
    
    private void validate() {
        if (task == null) {
            throw new IllegalStateException("Missing task!");
        }
    }
}
