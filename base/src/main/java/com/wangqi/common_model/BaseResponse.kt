package com.wangqi.common_model

import com.google.gson.annotations.SerializedName

open class BaseResponse {

    @SerializedName("code")
    var code: Int = 0

    @SerializedName("message")
    var message: String? = null
}
