package com.example.tomas.mytasks.board

import android.content.Context
import android.support.v7.widget.helper.ItemTouchHelper

interface BoardView {

    fun setPresenter(presenter: BoardPresenter)
    fun getContext(): Context
    fun showTasks(adapter: TaskAdapter)
    fun setOnItemTouchNotifier(callback: ItemTouchHelper.SimpleCallback)

}