package com.example.tomas.mytasks.utils

import android.graphics.drawable.Drawable
import android.view.View

class SwipeItemBounds {

    var top: Int = 0
    var left: Int = 0
    var right: Int = 0
    var bottom: Int = 0

    companion object {

        fun countBounds(icon: Drawable, itemView: View): SwipeItemBounds {

            val intrinsicWidth = icon.intrinsicWidth
            val intrinsicHeight = icon.intrinsicHeight
            val itemHeight = itemView.bottom - itemView.top
            val margin = (itemHeight - intrinsicHeight) / 2

            val top = itemView.top + (itemHeight - intrinsicHeight) / 2
            val left = itemView.right - margin - intrinsicWidth
            val right = itemView.right - margin
            val bottom = top + intrinsicHeight

            val itemBounds = SwipeItemBounds()
            itemBounds.top = top
            itemBounds.left = left
            itemBounds.right = right
            itemBounds.bottom = bottom

            return itemBounds
        }

    }
}