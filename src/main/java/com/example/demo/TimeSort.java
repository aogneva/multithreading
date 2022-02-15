package com.example.demo;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class TimeSort {
    public void sort() {
        Random r = new Random();
        IntStream.generate(() -> r.nextInt(10)).limit(10)
                .mapToObj(i-> new Thread(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(i);
                        System.out.println(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                })).forEach(Thread::start);
    }
}
