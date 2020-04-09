package com.yeungeek.kotlinprimer.chapter02;

import kotlin.io.FilesKt;

import java.io.File;
import java.nio.charset.Charset;

public class ExpandFun {
    public static void main(String[] args) {
        File file = new File("KotlinPrimer.iml");
        String text = FilesKt.readText(file, Charset.defaultCharset());
        System.out.println(text);
    }
}
