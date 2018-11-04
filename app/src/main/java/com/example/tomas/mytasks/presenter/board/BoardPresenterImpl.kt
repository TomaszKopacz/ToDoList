package com.example.tomas.mytasks.presenter.board

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.tomas.mytasks.app.MyNotesApp
import com.example.tomas.mytasks.entity.Task
import com.example.tomas.mytasks.interactor.TasksRepository
import com.example.tomas.mytasks.view.adapter.TaskAdapter
import com.example.tomas.mytasks.view.board.BoardView
import com.example.tomas.mytasks.view.creator.TaskMakerActivity
import javax.inject.Inject

class BoardPresenterImpl(private val view: BoardView) : BoardPresenter,
    TaskAdapter.OnItemClickListener,
    SwipeToDeleteCallback(view.getContext()) {

    @Inject
    lateinit var repository: TasksRepository

    init {
        injectDependencies()
        makeTasksList()
    }

    private fun injectDependencies() {
        (view.getContext().applicationContext as MyNotesApp).component.inject(this)
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

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
        repository.deleteTask((viewHolder as TaskAdapter.TaskViewHolder).getTask())
    }
}