package com.yeungeek.lagou.chapter07;

/**
 * javap -v bytecode
 */
public class SyncByteCodeTest {
    public static void main(String[] args) {

    }
    private int num;

    private synchronized void test() {
        int i = 0;
        synchronized (this) {
            num = i + 1;
        }
    }
}
