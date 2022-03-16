package ru.ogneva.multithreading;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.Future;

@Component
public class AsyncAnnotationExample {

    @Async
    public void asyncMethodWithVoidValue(int index) {
        System.out.println("Execute void method asynchronously: " + Thread.currentThread().getName() + " index: "+index);
    }

    @Async
    public Future<String> asyncMethodWithReturnValue(int index) {
        System.out.println("Execute future method asynchronously: " + Thread.currentThread().getName() + " index: "+index);
        try {
            Thread.sleep(200);
            return new AsyncResult<>("Hello from async method at " + Instant.now());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
