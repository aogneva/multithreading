package com.example.demo;

import java.sql.Timestamp;
import java.time.Instant;

public class SimpleThread extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("timestamp: " + Instant.now());
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
