package com.sirius.decorator;

public class GardenWorker implements Worker {
    @Override
    public void work() {
        System.out.println("Cutting grass");
    }
}
