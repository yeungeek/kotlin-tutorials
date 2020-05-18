package com.yeungeek.juc.sync;

public class HSDisTest {
    public static volatile int testN = 1;

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            testM();
            testN();
        }
    }

    private static synchronized void testM() {

    }

    private static void testN() {
        testN = 1;
    }
}
