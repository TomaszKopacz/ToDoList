package com.example.tomas.mytasks.presenter

import android.view.View
import com.example.tomas.mytasks.view.TaskAdapter

interface BoardPresenter {

    fun onAddTaskButtonClicked()

    fun onTaskClicked(view: View)
    fun onTaskLongClicked(view: View)
    fun onTaskSwipeLeft(view: View)

    fun onItemBoundAtPosition(holder: TaskAdapter.TaskViewHolder, position: Int)

    fun getTasksCount(): Int
}
