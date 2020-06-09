package com.yeungeek.lagou.chapter07;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantFairTest {
    public static void main(String[] args) {
        FairThread test = new FairThread();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        Thread t3 = new Thread(test);

        t1.start();
        t2.start();
        t3.start();
    }

    public static class FairThread implements Runnable {
        private int num = 0;
        private ReentrantLock lock = new ReentrantLock(true);

        @Override
        public void run() {
            while (num < 20) {
                System.out.println(Thread.currentThread().getName() + ",current num: " + num);
                lock.lock();
                try {
                    num++;
                    System.out.println(Thread.currentThread().getName() + " lock,num: " + num);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
