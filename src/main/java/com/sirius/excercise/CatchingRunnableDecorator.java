package com.sirius.excercise;

class CatchingRunnableDecorator implements Runnable {
    private final Runnable wrapped;
    
    CatchingRunnableDecorator(final Runnable wrapped) {
        this.wrapped = wrapped;
    }
    
    @Override
    public void run() {
        try {
            wrapped.run();
        } catch (Throwable e) {
            System.err.println("Oops! " + e.getMessage());
            throw e;
        }
    }
}
