package com.yeungeek.kotlinprimer

import java.net.URLDecoder

fun main() {
    val url = URLDecoder.decode(
        "http://3q.gs/work/com.rokid.glass.rplus_%E5%A4%9A%E4%BA%BA%E5%8D%8F%E4%BD%9C_V1.1.0.apk",
        "UTF-8"
    )
    println(url)
//
//    val fileName = url.substring(url.lastIndexOf("/") + 1).replace(".apk", "")
//    println(fileName)
//
//    val fileInfos = fileName.split("_").toTypedArray()
//    for (i in fileInfos.indices) {
//        println(fileInfos[i])
//        if (i == 2) {
//            println(
//                fileInfos[2]
//                    .replace(".", "")
//                    .replace("V", "")
//            )
//        }
//    }
//    var urlStr =
//        "https://rokid-ota.oss-cn-hangzhou.aliyuncs.com/toB/Rokid_Glass/app/QR/com.rokid.camera.cameradeploy_%E4%BA%BA%E8%84%B8%E8%AF%86%E5%88%AB_V5.1.7.apk"
    var fileInfos = splitUrl(url)
//    for (i in fileInfos.indices) {
//        println(fileInfos[i])
//    }

    for (fileInfo in fileInfos) {
        println(fileInfo)
    }
}

fun splitUrl(url: String): Array<String> {
    val decodeUrl = URLDecoder.decode(url, "UTF-8");
    return decodeUrl.substring(decodeUrl.lastIndexOf("/") + 1)?.replace(".apk", "")
        .split("_").toTypedArray()
}