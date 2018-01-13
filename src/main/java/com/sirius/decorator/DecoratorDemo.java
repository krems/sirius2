package com.sirius.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        Worker worker = new GardenWorker();
        //        worker.work();
    
        Worker profiledWorker = new ProfilingWorkerDecorator(worker);
        profiledWorker.work();
    }
}
