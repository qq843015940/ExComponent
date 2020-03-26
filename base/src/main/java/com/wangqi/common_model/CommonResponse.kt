package com.wangqi.common_model

import com.google.gson.annotations.SerializedName

class CommonResponse<T> {

    @SerializedName("data_list")
    var dataList: ArrayList<T>? = null

    @SerializedName("has_more")
    var hasMore: Boolean? = null
}