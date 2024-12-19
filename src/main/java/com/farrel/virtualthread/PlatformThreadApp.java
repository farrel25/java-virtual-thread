package com.farrel.virtualthread;

import java.time.Duration;

public class PlatformThreadApp {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            Thread thread = Thread.ofPlatform()
                    .name("farrel-thread-" + i)
                    .daemon(false)
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

    }
}
