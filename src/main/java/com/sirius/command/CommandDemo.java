package com.sirius.command;

import java.util.concurrent.*;

public class CommandDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
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
                System.out.println(Thread.currentThread().getName());
                long end = System.currentTimeMillis();
                System.out.println(name + " in queue: " + (start - timeCreated));
                System.out.println(name + " duration: " + (end - start));
                System.out.println(name + " total: " + (end - timeCreated));
            }
        };
        Thread.sleep(20);
        executor.submit(command);
        
        final Future<Integer> future = executor.submit(() -> {
            return 2 + 2;
        });
        
        final Integer integer = future.get();
        System.out.println(integer);
    
        executor.awaitTermination(100, TimeUnit.MILLISECONDS);
        executor.shutdownNow();
    }
}
