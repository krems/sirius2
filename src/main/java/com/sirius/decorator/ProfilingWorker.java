package com.sirius.decorator;

public class ProfilingWorker implements Worker {
    private final Worker worker;
    
    ProfilingWorker(Worker worker) {
        this.worker = worker;
    }
    
    @Override
    public void work() {
        long start = System.currentTimeMillis();
        worker.work();
        long duration = System.currentTimeMillis() - start;
        System.out.println("Took " + duration + "ms");
    }
}
