package com.yeungeek.kotlinprimer.chapter01;

public class JavaMain {
    public static void main(String[] args) {
        UtilsKt.echo("Java echo");

        Single.INSTANCE.sayHello("Java Single");
        Single.sayHello("Java Single");
    }
}
