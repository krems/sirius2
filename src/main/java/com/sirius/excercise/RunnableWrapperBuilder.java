package com.sirius.excercise;

public class RunnableWrapperBuilder {
    private Runnable task;
    private boolean useMeasurer;
    private boolean useCatcher;
    private boolean useNamer;
    
    public RunnableWrapperBuilder task(Runnable task) {
        this.task = task;
        return this;
    }
    
    public RunnableWrapperBuilder measuring() {
        useMeasurer = true;
        return this;
    }
    
    public RunnableWrapperBuilder catching() {
        useCatcher = true;
        return this;
    }
    
    public RunnableWrapperBuilder naming() {
        useNamer = true;
        return this;
    }
    
    public Runnable build() {
        validate();
        Runnable wrapped = this.task;
        if (useNamer) {
            wrapped = new NamingRunnableDecorator(wrapped);
        }
        if (useMeasurer) {
            wrapped = new MeasuringRunnableDecorator(wrapped);
        }
        if (useCatcher) {
            wrapped = new CatchingRunnableDecorator(wrapped);
        }
        return wrapped;
    }
    
    private void validate() {
        if (task == null) {
            throw new IllegalStateException("Missing task!");
        }
    }
}
