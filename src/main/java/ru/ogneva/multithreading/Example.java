package ru.ogneva.multithreading;

import java.util.concurrent.atomic.AtomicLong;

public class Example {

    public static void main(String[] args) throws InterruptedException {

        long maxIteration = 1_000_000;
        long expectedValue = 2 * maxIteration;

        CounterWrapper counterWrapper = new CounterWrapper();

        Thread thread1 = new Thread(() -> {
            for (int k = 0; k < maxIteration; k++) {
                counterWrapper.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int k = 0; k < maxIteration; k++) {
                counterWrapper.increment();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        if (counterWrapper.getCounter() == expectedValue)
            System.out.println("OK");
        else
            System.err.println(String.format("ERROR: expected %d, current value %d",
                    expectedValue, counterWrapper.getCounter()));
    }

    static class CounterWrapper {
        volatile AtomicLong counter = new AtomicLong(0l);

        public void increment() {
            counter.incrementAndGet();
        }

        public long getCounter() {
            return counter.get();
        }

    }

}