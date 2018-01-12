package com.sirius.excercise;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class PumpedExecutorService implements ExecutorService {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final boolean useMeasurer;
    private final boolean useCatcher;
    private final boolean useNamer;
    
    private PumpedExecutorService(final boolean useMeasurer, final boolean useCatcher, final boolean useNamer) {
        this.useMeasurer = useMeasurer;
        this.useCatcher = useCatcher;
        this.useNamer = useNamer;
    }
    
    public static PumpedExecutorService measuringExecutorService() {
        return new PumpedExecutorService(true, false, false);
    }
    
    public static PumpedExecutorService namingExecutorService() {
        return new PumpedExecutorService(false, false, true);
    }
    
    public static PumpedExecutorService fullExecutorService() {
        return new PumpedExecutorService(true, true, true);
    }
    
    @Override
    public <T> Future<T> submit(final Callable<T> task) {
        final Callable<T> callable = CallableWrapperBuilder.of(task)
                .catching(useCatcher)
                .measuring(useMeasurer)
                .naming(useNamer).build();
        return executor.submit(callable);
    }
    
    @Override
    public <T> Future<T> submit(final Runnable task, final T result) {
        final Runnable wrapped = RunnableWrapperBuilder.of(task)
                .catching(useCatcher)
                .measuring(useMeasurer)
                .naming(useNamer).build();
        return executor.submit(wrapped, result);
    }
    
    @Override
    public Future<?> submit(final Runnable task) {
        final Runnable wrapped = RunnableWrapperBuilder.of(task)
                .catching(useCatcher)
                .measuring(useMeasurer)
                .naming(useNamer).build();
        return executor.submit(wrapped);
    }
    
    @Override
    public void execute(final Runnable command) {
        final Runnable wrapped = RunnableWrapperBuilder.of(command)
                .catching(useCatcher)
                .measuring(useMeasurer)
                .naming(useNamer).build();
        executor.execute(wrapped);
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
