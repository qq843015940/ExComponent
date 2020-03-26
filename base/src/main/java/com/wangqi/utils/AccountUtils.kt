package com.wangqi.utils

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import com.wangqi.constants.Constants
import com.wangqi.utils.SpUtils

object AccountUtils {

    fun isLogin(context: Context?): Boolean {
        val sp = SpUtils.getSp(context, Constants.Account.ACCOUNT_SP)
        val uid = sp?.getString("uid", "")
        return !TextUtils.isEmpty(uid)
    }

    fun getUid(context: Context?): String {
        val sp = SpUtils.getSp(context, Constants.Account.ACCOUNT_SP)
        val uid = sp?.getString("uid", "")
        return uid ?: ""
    }

    fun logout(context: Context?) {
        val sp = SpUtils.getSp(context, Constants.Account.ACCOUNT_SP)
        sp?.edit()?.run {
            putString("uid", "")
            apply()
        }

    }
}