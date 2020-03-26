package com.wangqi.uikit

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CardItemDecoration(private val margin: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        val params = view.layoutParams as GridLayoutManager.LayoutParams
        if (params.spanIndex % 2 == 0) {
            outRect.left = margin
            outRect.right = margin / 2
        } else {
            outRect.left = margin / 2
            outRect.right = margin
        }
        outRect.top = margin
    }

}