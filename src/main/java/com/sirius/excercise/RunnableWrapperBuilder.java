package com.sirius.excercise;

class RunnableWrapperBuilder {
    private final Runnable task;
    private boolean useMeasurer;
    private boolean useCatcher;
    private boolean useNamer;
    
    private RunnableWrapperBuilder(final Runnable task) {
        this.task = task;
    }
    
    public static RunnableWrapperBuilder of(final Runnable task) {
        return new RunnableWrapperBuilder(task);
    }
    
    public RunnableWrapperBuilder measuring(final boolean measuring) {
        useMeasurer = measuring;
        return this;
    }
    
    public RunnableWrapperBuilder catching(final boolean catching) {
        useCatcher = catching;
        return this;
    }
    
    public RunnableWrapperBuilder naming(final boolean naming) {
        useNamer = naming;
        return this;
    }
    
    public Runnable build() {
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
}
