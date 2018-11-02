package com.example.tomas.mytasks.view.board

import android.content.Context
import android.support.v7.widget.helper.ItemTouchHelper
import com.example.tomas.mytasks.view.adapter.TaskAdapter

interface BoardView {

    fun getContext(): Context
    fun showTasks(adapter: TaskAdapter)
    fun setOnItemTouchNotifier(callback: ItemTouchHelper.SimpleCallback)

}