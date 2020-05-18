package com.yeungeek.kotlinprimer.chapter10

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
    val file = File("build.gradle")
    val destFile = File("files/build.txt")

    if (!destFile.exists()) {
        destFile.parentFile.mkdirs()
        destFile.createNewFile()
    }

    copyFile(file, destFile)
}

fun copyFile(source: File, dest: File) {
    FileInputStream(source).use { input ->
        FileOutputStream(dest).use { output ->
            val buffer = ByteArray(1024)
            while (true) {
                val byteRead = input.read(buffer)
                if (byteRead <= 0) {
                    break;
                }

                output.write(buffer, 0, byteRead)
            }
        }
    }
}

