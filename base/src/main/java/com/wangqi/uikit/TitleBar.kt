package com.wangqi.uikit

import android.app.Activity
import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.wangqi.common_model.R
import kotlinx.android.synthetic.main.title_bar_view.view.*

class TitleBar(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    private var mListener: RightButtonOnClick? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.title_bar_view, this, true)


        val a = context.obtainStyledAttributes(attrs, R.styleable.TitleBar)
        val text = a.getString(R.styleable.TitleBar_title)
        val rightText = a.getString(R.styleable.TitleBar_rightButtonText)
        a.recycle()

        if (!TextUtils.isEmpty(text)) {
            tv_title.text = text
        }

        if (!TextUtils.isEmpty(rightText)) {
            rightButton.apply {
                visibility = View.VISIBLE
                setOnClickListener { mListener?.onClick() }
                setText(rightText)
            }

        }

        btn_back.setOnClickListener {
            if (context is Activity) {
                context.finish()
            }
        }


    }

    fun setRightButtonOnClickListener(listener: RightButtonOnClick) {
        this.mListener = listener
    }


    interface RightButtonOnClick {
        fun onClick()
    }
}