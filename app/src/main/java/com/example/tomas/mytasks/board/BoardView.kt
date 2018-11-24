package com.example.tomas.mytasks.board

import android.arch.lifecycle.LiveData
import android.content.Context
import com.example.tomas.mytasks.db.entity.Task

interface BoardView {

    fun setPresenter(presenter: BoardPresenter)
    fun getContext(): Context
    fun showTasks(tasks: LiveData<List<Task>>, listener: TaskAdapter.OnItemClickListener)
}