package com.farrel.virtualthread;

import java.io.IOException;
import java.time.Duration;

public class VirtualThreadApp {

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 10_000; i++) {

            Thread thread = Thread.ofVirtual()
                    .name("farrel-thread-" + i)
                    .unstarted(() -> {
                        try {
                            Thread.sleep(Duration.ofSeconds(2));
                            System.out.println(Thread.currentThread()+ " is running");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });

            thread.start();

        }

        System.in.read();
    }
}
