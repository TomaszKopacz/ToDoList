package com.example.tomas.mytasks.board

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.tomas.mytasks.db.entity.Task
import com.example.tomas.mytasks.db.TasksRepository
import com.example.tomas.mytasks.creator.TaskMakerActivity

class BoardPresenterImpl(private val view: BoardView,
                         private val repository: TasksRepository)
    : BoardPresenter,
    TaskAdapter.OnItemClickListener,
    SwipeToDeleteCallback(view.getContext()) {

    init {
        makeTasksList()
    }

    private fun makeTasksList() {
        addTouchEventsToTasks()
        displayTasks()
    }

    private fun addTouchEventsToTasks() {
        view.setOnItemTouchNotifier(this)
    }


    private fun displayTasks() {
        repository.getAllTasks().observe(view.getContext() as LifecycleOwner, Observer {
            view.showTasks(TaskAdapter(it!!, this))
        })
    }

    override fun onAddTaskButtonClicked() {
        val intent = Intent(view.getContext(), TaskMakerActivity::class.java)
        view.getContext().startActivity(intent)
    }

    override fun onItemClick(task: Task, itemView: View) {

    }

    override fun onItemLongClick(task: Task, it: View?) {
        val dialog = ProgressDialog(view.getContext())
        dialog.show("Change priority:", task.priority, object : ProgressDialog.ProgressDialogListener {
            override fun progressChanged(progress: Int) {
                task.priority = progress
                repository.updateTask(task)
            }
        })
    }

    override fun onTitleLongClick(task: Task, it: View?): Boolean {
        val dialog = TextDialog(view.getContext())
        dialog.show("Change title:", task.title, object : TextDialog.TextDialogListener {
            override fun textChanged(text: String) {
                task.title = text
                repository.updateTask(task)
            }

        })
        return true
    }

    override fun onDeadlineLongClick(task: Task, it: View?) {
        val dialog = TextDialog(view.getContext())
        dialog.show("Change deadline:", task.deadline, object : TextDialog.TextDialogListener {
            override fun textChanged(text: String) {
                task.deadline = text
                repository.updateTask(task)
            }
        })
    }

    override fun onDescriptionLongClick(task: Task, it: View?) {
        val dialog = TextDialog(view.getContext())
        dialog.show("Change description:", task.description, object : TextDialog.TextDialogListener {
            override fun textChanged(text: String) {
                task.description = text
                repository.updateTask(task)
            }
        })
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
        repository.deleteTask((viewHolder as TaskAdapter.TaskViewHolder).getTask())
    }
}