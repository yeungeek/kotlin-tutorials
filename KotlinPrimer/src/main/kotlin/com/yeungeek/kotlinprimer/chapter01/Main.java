package com.yeungeek.kotlinprimer.chapter01;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        boolean result = new Random().nextBoolean();
        System.out.println(result);
        if (!result) {
            while (count < 3) {
                result = new Random().nextBoolean();
                System.out.println(result);
                if (!result) {
                    System.out.println(count++);
                } else {
                    break;
                }
            }
        }
    }
}
