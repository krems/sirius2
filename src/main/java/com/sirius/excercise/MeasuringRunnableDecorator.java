package com.sirius.excercise;

public class MeasuringRunnableDecorator implements Runnable {
    private final Runnable wrapped;
    
    public MeasuringRunnableDecorator(final Runnable wrapped) {
        this.wrapped = wrapped;
    }
    
    @Override
    public void run() {
        final long start = System.currentTimeMillis();
        try {
            wrapped.run();
        } finally {
            System.out.println(System.currentTimeMillis() - start);
        }
    }
}
