package com.wangqi.utils

import java.lang.StringBuilder
import java.util.*

object RandomUtils {
    fun getRandomDigit(num: Int): String {
        val sb = StringBuilder()
        val random = Random()
        for (i in 0..num) {
            sb.append(random.nextInt(10))
        }
        return sb.toString()
    }

    fun getRandomKey(num: Int): String {
        val sb = StringBuilder()
        val random = Random()
        while (sb.length < num) {
            val n = random.nextInt(61) + 30
            if (n in 48..57 || n in 65..90) {
                sb.append(n.toChar())
            }
        }
        return sb.toString()
    }
}