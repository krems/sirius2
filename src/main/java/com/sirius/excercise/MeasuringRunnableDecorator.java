package com.sirius.excercise;

class MeasuringRunnableDecorator implements Runnable {
    private final Runnable wrapped;
    
    MeasuringRunnableDecorator(final Runnable wrapped) {
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
