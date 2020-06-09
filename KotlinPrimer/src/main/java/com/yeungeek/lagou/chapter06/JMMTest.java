package com.yeungeek.lagou.chapter06;

import java.util.concurrent.CountDownLatch;

public class JMMTest {
//    CountDownLatch downLatch = new CountDownLatch(2);
//
//    public static void main(String[] args) throws InterruptedException {
//        JMMTest test = new JMMTest();
//
//        test.p1.start();
//        test.p2.start();
//
//        test.downLatch.await();
//        System.out.println("r1: " + test.x + ", " + ",r2: " + test.y);
//    }

    //cache

    public static void main(String[] args) {

    }

    public int x;
    public int y;

    Thread p1 = new Thread() {
        @Override
        public void run() {
            int r1 = x;
            y = 1;
        }
    };

    Thread p2 = new Thread() {
        @Override
        public void run() {
            int r2 = y;
            x = 2;
        }
    };
}
