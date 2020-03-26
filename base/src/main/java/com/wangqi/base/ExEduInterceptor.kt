package com.wangqi.base

import com.wangqi.utils.NetworkUtils
import okhttp3.*

class ExEduInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        if (NetworkUtils.useProxy()) {

            return chain.proceed(Request.Builder().build())

//            return Response.Builder().build()
        }


        return chain.proceed(chain.request())
    }


}