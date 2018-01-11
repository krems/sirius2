package com.sirius.command;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CommandDemo {
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        final Runnable command = new Runnable() {
            private final long timeCreated = System.currentTimeMillis();
            private final String name = "MyTask";
            
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                long end = System.currentTimeMillis();
                System.out.println(name + " in queue: " + (start - timeCreated));
                System.out.println(name + " duration: " + (end - start));
                System.out.println(name + " total: " + (end - timeCreated));
            }
        };
        Thread.sleep(20);
        executor.submit(command);
        
        executor.awaitTermination(100, TimeUnit.MILLISECONDS);
        executor.shutdownNow();
    }
}
