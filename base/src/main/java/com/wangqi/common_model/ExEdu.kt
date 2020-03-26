package com.wangqi.common_model

import com.google.gson.annotations.SerializedName

class ExEdu {

    @SerializedName("eid")
    var eid: String? = null

    @SerializedName("coast")
    var coast: String? = null

    @SerializedName("lesson_type")
    var type: String? = null

    @SerializedName("img")
    var img: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("create_time")
    var createTime: String? = null

    @SerializedName("class_time")
    var classTime: String? = null

    @SerializedName("position")
    var position: String? = null

    @SerializedName("description")
    var desc: String? = null

    @SerializedName("creator")
    var creator: User? = null



}