package com.yeungeek.juc.sync;

import org.openjdk.jol.info.ClassLayout;

public class JOLTest {
    //mark word
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
