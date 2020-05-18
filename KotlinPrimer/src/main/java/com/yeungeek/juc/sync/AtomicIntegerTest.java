package com.yeungeek.juc.sync;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
//    private /*volatile*/ int count;

    private AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        AtomicIntegerTest test = new AtomicIntegerTest();

        CountDownLatch downLatch = new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                test.countPlus();

                downLatch.countDown();
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        downLatch.await();

        System.out.println("count: " + test.count);
    }

    private  /*synchronized*/ void countPlus() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();//count++;
        }
    }
}
