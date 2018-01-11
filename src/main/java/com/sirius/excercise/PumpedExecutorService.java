package com.sirius.excercise;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class PumpedExecutorService implements ExecutorService {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    
    @Override
    public <T> Future<T> submit(final Callable<T> task) {
        return executor.submit(task);
    }
    
    @Override
    public <T> Future<T> submit(final Runnable task, final T result) {
        return executor.submit(task, result);
    }
    
    @Override
    public Future<?> submit(final Runnable task) {
        return executor.submit(task);
    }
    
    @Override
    public void execute(final Runnable command) {
        executor.execute(command);
    }
    
    @Override
    public void shutdown() {
        executor.shutdown();
    }
    
    @Override
    public List<Runnable> shutdownNow() {
        return executor.shutdownNow();
    }
    
    @Override
    public boolean isShutdown() {
        return executor.isShutdown();
    }
    
    @Override
    public boolean isTerminated() {
        return executor.isTerminated();
    }
    
    @Override
    public boolean awaitTermination(final long timeout, final TimeUnit unit) throws InterruptedException {
        return executor.awaitTermination(timeout, unit);
    }
    
    @Override
    public <T> List<Future<T>> invokeAll(final Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return executor.invokeAll(tasks);
    }
    
    @Override
    public <T> List<Future<T>> invokeAll(final Collection<? extends Callable<T>> tasks, final long timeout, final TimeUnit unit) throws InterruptedException {
        return executor.invokeAll(tasks, timeout, unit);
    }
    
    @Override
    public <T> T invokeAny(final Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return executor.invokeAny(tasks);
    }
    
    @Override
    public <T> T invokeAny(final Collection<? extends Callable<T>> tasks, final long timeout, final TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return executor.invokeAny(tasks, timeout, unit);
    }
}
