package com.wangqi.utils

import android.text.TextUtils
import com.wangqi.base.ExEduInterceptor
import okhttp3.OkHttpClient

object NetworkUtils {

    fun useProxy(): Boolean {
        val proxyAddress = System.getProperty("http.proxyHost")
        val portStr = System.getProperty("http.proxyPort")

        return !TextUtils.isEmpty(proxyAddress) && !TextUtils.isEmpty(portStr)

    }

    fun getClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(ExEduInterceptor())

            .build()

    }
}