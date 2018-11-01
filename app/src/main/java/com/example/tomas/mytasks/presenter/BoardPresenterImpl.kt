package com.example.tomas.mytasks.presenter

import android.view.View
import com.example.tomas.mytasks.entity.Task
import com.example.tomas.mytasks.view.BoardView
import com.example.tomas.mytasks.view.TaskAdapter

class BoardPresenterImpl(private val view: BoardView) : BoardPresenter {

    private var tasks = ArrayList<Task>()
    private var adapter = TaskAdapter(this)

    override fun onAddTaskButtonClicked() {

    }

    override fun onTaskClicked(view: View) {

    }

    override fun onTaskLongClicked(view: View) {

    }

    override fun onTaskSwipeLeft(view: View) {

    }

    override fun onItemBoundAtPosition(holder: TaskAdapter.TaskViewHolder, position: Int) {
        adapter.setContent(holder, tasks[position])
    }

    override fun getTasksCount(): Int {
        return tasks.size
    }
}