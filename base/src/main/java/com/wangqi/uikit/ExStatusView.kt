package com.wangqi.uikit

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.wangqi.common_model.R

class ExStatusView(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    private val text: TextView

    private val lottieView: LottieAnimationView

    private var status = 0

    init {
        LayoutInflater.from(context).inflate(R.layout.ex_status_view, this, true)
        text = findViewById(R.id.tv_notion)
        lottieView = findViewById(R.id.lottie_view)
    }


    fun showLoading() {
        status = 1
        lottieView.setAnimation("loading.json")
        lottieView.scale = 0.8F
        lottieView.playAnimation()
    }

    fun reset() {
        if (status != 0) {
            status = 0
            lottieView.cancelAnimation()
            lottieView.visibility = View.GONE
        }
    }

    fun showDragon() {
        status = 1
        lottieView.setAnimation("dragon.json")
        lottieView.scale = 0.8F
        lottieView.playAnimation()
    }

    fun showNothing() {
        status = 1
        text.text = "没有数据"
        lottieView.setAnimation("empty.json")
        lottieView.playAnimation()
    }

    fun showVideoLoading() {
        status = 1
        lottieView.setAnimation("video_loading.json")
        lottieView.scale = 0.5F
        lottieView.playAnimation()

    }





}