package com.sirius.excercise;

class NamingRunnableDecorator implements Runnable {
    private final Runnable wrapped;
    
    NamingRunnableDecorator(final Runnable wrapped) {
        this.wrapped = wrapped;
    }
    
    @Override
    public void run() {
        final String oldName = Thread.currentThread().getName();
        Thread.currentThread().setName(wrapped.getClass().getName());
        try {
            wrapped.run();
        } finally {
            Thread.currentThread().setName(oldName);
        }
    }
}
