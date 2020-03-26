package com.wangqi.common_model

import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("uid")
    var uid: String? = null

    @SerializedName("account")
    var account: String? = null

    @SerializedName("money")
    var money: String? = null

    @SerializedName("avatar")
    var avatar: String? = null

    @SerializedName("nick_name")
    var nickName: String? = null

}