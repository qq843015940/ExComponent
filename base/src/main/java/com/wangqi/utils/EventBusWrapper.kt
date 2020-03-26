package com.wangqi.utils

import org.greenrobot.eventbus.EventBus

object EventBusWrapper {


    fun post(obj: Any) {
        EventBus.getDefault().post(obj)
    }

    fun postSticky(obj: Any) {
        EventBus.getDefault().postSticky(obj)
    }

    fun register(subscriber: Any) {
        if (!EventBus.getDefault().isRegistered(subscriber)) {
            EventBus.getDefault().register(subscriber)
        }

    }

    fun unregister(subscriber: Any) {
        if (EventBus.getDefault().isRegistered(subscriber)) {
            EventBus.getDefault().unregister(subscriber)
        }

    }

    fun isRegistered(subscriber: Any): Boolean {
        return EventBus.getDefault().isRegistered(subscriber)
    }

}