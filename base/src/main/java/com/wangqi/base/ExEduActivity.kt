package com.wangqi.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wangqi.utils.EventBusWrapper

open class ExEduActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isRegisterEventBus()) {
            EventBusWrapper.register(this)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (isRegisterEventBus()) {
            EventBusWrapper.unregister(this)
        }

    }

    open fun isRegisterEventBus(): Boolean {
        return false
    }
}