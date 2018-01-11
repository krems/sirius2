package com.sirius.fabric;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FabricDemo {
    public static void main(String[] args) {
        final ExecutorService cachedExecutorService = Executors.newCachedThreadPool();
        final ExecutorService fixedExecutorService = Executors.newFixedThreadPool(10);
        final ExecutorService SingleThreadExecutorService = Executors.newSingleThreadExecutor();
    }
}
