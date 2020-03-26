package com.wangqi.uikit

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.wangqi.common_model.R

class ExItemView(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    private var mLeftView: ImageView
    private var mLeftText: TextView


    init {
        LayoutInflater.from(context).inflate(R.layout.ex_item_view, this, true)
        mLeftView = findViewById(R.id.left_img)
        mLeftText = findViewById(R.id.left_text)

        val a = context.obtainStyledAttributes(attrs, R.styleable.ExItemView)
        val text = a.getString(R.styleable.ExItemView_leftText)
        val view = a.getDrawable(R.styleable.ExItemView_leftView)
        a.recycle()

        if (!TextUtils.isEmpty(text)) {
            mLeftText.text = text
        }
        view?.let { mLeftView.setImageDrawable(it) }

    }

    fun setLeftView(view: Int) {
        mLeftView.setImageResource(view)
    }

    fun setLeftText(text: Int) {
        mLeftText.text = context.getString(text)
    }

    fun setLeftText(text: String) {
        mLeftText.text = text
    }

}