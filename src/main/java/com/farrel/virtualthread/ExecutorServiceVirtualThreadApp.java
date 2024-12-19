package com.farrel.virtualthread;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceVirtualThreadApp {

    public static void main(String[] args) throws IOException {

        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10_000; i++) {
                executorService.execute(() -> {
                    try {
                        Thread.sleep(Duration.ofSeconds(2));
                        System.out.println(Thread.currentThread() + " is running");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

            }
        }

        System.in.read();
    }
}
