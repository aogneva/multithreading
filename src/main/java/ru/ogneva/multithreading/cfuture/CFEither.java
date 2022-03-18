package ru.ogneva.multithreading.cfuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CFEither {
    static int PAUSE = 1;
    public static void main(String[] args) {
        Supplier<String> firstSup = () -> {
            String ret = "1";
            System.out.println("Start " + ret);
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(PAUSE));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End " + ret);
            return ret;
        };
        Supplier<String> secondSup = () -> {
            String ret = "2";
            System.out.println("Start " + ret);
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(PAUSE));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End " + ret);
            return ret;
        };

        CompletableFuture<String> secondCf = CompletableFuture.supplyAsync(secondSup);
        CompletableFuture<String> firstCf = CompletableFuture.supplyAsync(firstSup);

        firstCf.acceptEither(secondCf, System.out::println);
        try {
            firstCf.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
