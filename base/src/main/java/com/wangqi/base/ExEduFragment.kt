package com.wangqi.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.wangqi.utils.EventBusWrapper

open class ExEduFragment : Fragment() {
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