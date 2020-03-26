package com.wangqi.utils

import android.content.Context
import android.content.SharedPreferences
import com.wangqi.constants.Constants

object SpUtils {
    fun getSp(context: Context?, str: String): SharedPreferences? =
        context?.getSharedPreferences(str, Context.MODE_PRIVATE)

}