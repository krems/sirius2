package com.sirius.excercise;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class PumpedExecutorService implements ExecutorService {
    private final ExecutorService executorService =
            Executors.newSingleThreadExecutor();
    
    @Override
    public Future<?> submit(final Runnable task) {
        return executorService.submit(task);
    }
    
    @Override
    public void execute(final Runnable command) {
        executorService.execute(command);
    }
    
    @Override
    public <T> Future<T> submit(final Callable<T> task) {
        return executorService.submit(task);
    }
    
    @Override
    public <T> Future<T> submit(final Runnable task, final T result) {
        return executorService.submit(task, result);
    }
    
    @Override
    public void shutdown() {
    
    }
    
    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }
    
    @Override
    public boolean isShutdown() {
        return false;
    }
    
    @Override
    public boolean isTerminated() {
        return false;
    }
    
    @Override
    public boolean awaitTermination(final long timeout, final TimeUnit unit) throws InterruptedException {
        return false;
    }
    
    @Override
    public <T> List<Future<T>> invokeAll(final Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return null;
    }
    
    @Override
    public <T> List<Future<T>> invokeAll(final Collection<? extends Callable<T>> tasks, final long timeout, final TimeUnit unit) throws InterruptedException {
        return null;
    }
    
    @Override
    public <T> T invokeAny(final Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return null;
    }
    
    @Override
    public <T> T invokeAny(final Collection<? extends Callable<T>> tasks, final long timeout, final TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
