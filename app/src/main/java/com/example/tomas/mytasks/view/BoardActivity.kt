package com.example.tomas.mytasks.view

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.tomas.mytasks.R
import com.example.tomas.mytasks.presenter.BoardPresenter
import com.example.tomas.mytasks.presenter.BoardPresenterImpl
import kotlinx.android.synthetic.main.activity_board.*

class BoardActivity : AppCompatActivity(), BoardView {

    private var presenter: BoardPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        presenter = BoardPresenterImpl(this)

        add_task_button.setOnClickListener {
            if (presenter != null)
                presenter!!.onAddTaskButtonClicked()
        }

        prepareContent()
    }

    override fun getContext(): Context {
        return this
    }

    override fun setPresenter(presenter: BoardPresenter) {
        this.presenter = presenter
    }

    private fun prepareContent() {
        prepareTasksList()
    }

    private fun prepareTasksList() {
        tasks_list.setHasFixedSize(true)
        tasks_list.layoutManager = LinearLayoutManager(this)
        tasks_list.itemAnimator = DefaultItemAnimator()
    }

    override fun displayTasks(adapter: TaskAdapter) {
        if (tasks_list != null)
            tasks_list.adapter = adapter
    }
}
