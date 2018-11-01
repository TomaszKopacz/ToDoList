package com.example.tomas.mytasks.view.board

import android.content.Context
import com.example.tomas.mytasks.presenter.board.BoardPresenter
import com.example.tomas.mytasks.view.adapter.TaskAdapter

interface BoardView {

    fun getContext() : Context
    fun showTasks(adapter: TaskAdapter)
}