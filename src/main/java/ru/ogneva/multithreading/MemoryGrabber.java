package ru.ogneva.multithreading;

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
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("1");
            return 1;
        } catch (Throwable e) {
            System.out.println("2");
            return 2;
        } finally {
            System.out.println("3");
            return 3;
        }
    }

    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Res: "+ex1());
//            executor.submit(() -> {
//                grabAllMemory();
//            }).get();
        } catch (Exception e) {
        }
    }
}
