package com.yeungeek.lagou.chapter07;

public class SynchronizedTest {
    private Object o = new Object();

    public static void main(String[] args) {
        SynchronizedTest s1 = new SynchronizedTest();
        SynchronizedTest s2 = new SynchronizedTest();

        Thread t1 = new Thread() {
            @Override
            public void run() {
//                s1.printLog();
//                printSLog();

                s1.printCLog();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
//                s2.printLog();
//                s1.printLog();
//                printSLog();

                s1.printCLog();
            }
        };

        t1.start();
        t2.start();
    }

    //1. method
    public synchronized void printLog() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ", value:" + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //2. static
    public static synchronized void printSLog() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ", value:" + i);
        }
    }

    //3.code
    public void printCLog() {
        synchronized (o) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ", value:" + i);
            }
        }
    }
}
