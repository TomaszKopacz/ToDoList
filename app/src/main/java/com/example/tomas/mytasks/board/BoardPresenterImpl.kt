package com.example.tomas.mytasks.board

import android.arch.lifecycle.LiveData
import android.content.Intent
import android.view.View
import com.example.tomas.mytasks.creator.TaskMakerActivity
import com.example.tomas.mytasks.db.TasksRepository
import com.example.tomas.mytasks.db.entity.Task

class BoardPresenterImpl(
    private val view: BoardView,
    private val repository: TasksRepository
) : BoardPresenter,
    TaskAdapter.OnItemClickListener {

    private var tasks: LiveData<List<Task>>? = null

    init {
        makeTasksList()
    }

    private fun makeTasksList() {
        downloadTasks()
        displayTasks()
    }

    private fun downloadTasks() {
        tasks = repository.getAllTasks()
    }

    private fun displayTasks() {
        if (tasks != null)
            view.showTasks(tasks!!, this)
    }

    override fun onAddTaskButtonClicked() {
        val intent = Intent(view.getContext(), TaskMakerActivity::class.java)
        view.getContext().startActivity(intent)
    }

    override fun onItemClick(task: Task, itemView: View) {

    }

    override fun onItemLongClick(task: Task, itemView: View?) {
        showModifierDialog(Task.PRIORITY, task)
    }

    override fun onItemSwiped(task: Task, itemView: View) {
        repository.deleteTask(task)
    }

    override fun onTitleLongClick(task: Task, itemView: View?) {
        showModifierDialog(Task.TITLE, task)
    }

    override fun onDescriptionLongClick(task: Task, itemView: View?) {
        showModifierDialog(Task.PRIORITY, task)
    }

    override fun onDeadlineLongClick(task: Task, itemView: View?) {
        showModifierDialog(Task.TERMINATION, task)
    }

    private fun showModifierDialog(field: String, task: Task) {
        val dialog = ModifierDialog(view.getContext())
        dialog.show()

    }
}