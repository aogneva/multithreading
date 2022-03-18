package ru.ogneva.multithreading.cfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CFAcceptAsync {

    public static void main(String[] args) {
        int PAUSE = 3;
        System.out.println("Request received");
        Supplier<String> sup = () -> {
            System.out.println("Query started");
            try { TimeUnit.SECONDS.sleep(PAUSE);} catch (InterruptedException e) {e.printStackTrace();}
            return "completed";
        };
        System.out.println("Query created");
        CompletableFuture.supplyAsync(sup).thenAcceptAsync((s) ->  System.out.printf("Query result: %s\n", s) );
        System.out.println("Program continue......");
        try { TimeUnit.SECONDS.sleep(PAUSE + 2);} catch (InterruptedException e) {e.printStackTrace();}
        System.out.println("......Program finished.");
    }
}
