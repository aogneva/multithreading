package com.example.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MemoryGrabber {
    static final List<Object[]> arrays = new LinkedList<>();

    class MyClass implements AutoCloseable {
        @Override
        public void close() throws Exception {

        }
    }
    public static void grabAllMemory() {
        for (; ; ) {
            arrays.add(new Object[100]);
        }
    }
    private static final int ex1(){
        try {
//            throw new Exception();
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws Exception {
        try {
            System.out.println(ex1());
//            executor.submit(() -> {
//                grabAllMemory();
//            }).get();
        } catch (Exception e) {
        }
    }
}
