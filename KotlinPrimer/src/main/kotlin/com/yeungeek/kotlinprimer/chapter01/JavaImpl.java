package com.yeungeek.kotlinprimer.chapter01;

public class JavaImpl implements JavaInterface {
    @Override
    public void println(int num) {
        System.out.println("int");
    }

    @Override
    public void println(Integer num) {
        System.out.println("Integer");
    }

    @Override
    public String format(String str) {
        return str.isEmpty() ? null : str;
    }
}
