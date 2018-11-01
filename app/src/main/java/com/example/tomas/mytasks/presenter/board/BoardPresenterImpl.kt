package com.example.tomas.mytasks.presenter.board

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.content.Intent
import android.view.View
import com.example.tomas.mytasks.app.MyNotesApp
import com.example.tomas.mytasks.entity.Task
import com.example.tomas.mytasks.view.adapter.TaskAdapter
import com.example.tomas.mytasks.view.board.BoardView
import com.example.tomas.mytasks.view.creator.TaskMakerActivity

class BoardPresenterImpl(private val view: BoardView) : BoardPresenter, TaskAdapter.OnItemClickListener {


    init {
        displayTasks()
    }

    override fun onItemClick(task: Task, itemView: View) {

    }

    override fun onAddTaskButtonClicked() {
        val intent = Intent(view.getContext(), TaskMakerActivity::class.java)
        view.getContext().startActivity(intent)
    }

    private fun displayTasks() {
        val tasksRepository = (view.getContext().applicationContext as MyNotesApp).getTasksRepository()
        tasksRepository.getAllTasks().observe(view.getContext() as LifecycleOwner, Observer {
            view.showTasks(TaskAdapter(it!!, this))
        })
    }
}