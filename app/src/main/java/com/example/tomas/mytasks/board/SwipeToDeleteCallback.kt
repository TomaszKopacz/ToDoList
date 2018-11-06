package com.example.tomas.mytasks.board

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import com.example.tomas.mytasks.R
import com.example.tomas.mytasks.utils.SwipeItemBounds

abstract class SwipeToDeleteCallback(context: Context) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

    private val deleteIcon = ContextCompat.getDrawable(context, R.drawable.ic_delete_task)
    private val background = ColorDrawable()
    private val backgroundColor = Color.parseColor("#f44336")

    override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
        return false
    }

    override fun onChildDraw(
        c: Canvas?, recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder,
        dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {

        val itemView = viewHolder.itemView

        val isCanceled = dX == 0f
        if (isCanceled) {
            c?.drawRect(itemView.right + dX, itemView.top.toFloat(), itemView.right.toFloat(), itemView.bottom.toFloat(), null)
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            return
        }

        drawDeletionBackground(itemView, dX, c)
        drawDeletionIcon(itemView, deleteIcon!!, c)

        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

    private fun drawDeletionBackground(itemView: View, dX: Float, c: Canvas?) {
        background.color = backgroundColor
        background.setBounds(itemView.right + dX.toInt(), itemView.top, itemView.right, itemView.bottom)
        background.draw(c)
    }

    private fun drawDeletionIcon(itemView: View, deleteIcon: Drawable, c: Canvas?) {
        val bounds = SwipeItemBounds.countBounds(deleteIcon, itemView)
        deleteIcon.setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom)
        deleteIcon.draw(c)
    }
}