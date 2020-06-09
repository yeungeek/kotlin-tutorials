package com.yeungeek.lagou.chapter07;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockTest {
    ReentrantLock lock = new ReentrantLock();

    final static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static String number = "0";

    public static void main(String[] args) {
        ReentrantLockTest r = new ReentrantLockTest();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                r.printLog();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                r.printLog();
            }
        };

//        t1.start();
//        t2.start();
    }

    public void printLog() {
        try {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ", value:" + i);
            }
        } finally {
            lock.unlock();
        }
    }


    static class Reader implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 10; i++) {
                readWriteLock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + ", value:" + number);
                readWriteLock.readLock().unlock();
            }
        }
    }
}
