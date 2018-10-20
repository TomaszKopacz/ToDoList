package com.example.tomas.mytasks.view

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tomas.mytasks.R
import com.example.tomas.mytasks.presenter.TaskCreator
import kotlinx.android.synthetic.main.activity_task_creator.*

class TaskCreatorActivity : AppCompatActivity(), TaskView {

    var presenter: TaskCreator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_creator)

        submit_task_button.setOnClickListener {
            presenter?.createTask()
        }
    }

    override fun getContext(): Context {
        TODO("not implemented")
    }

    override fun getTaskTitle(): String {
        TODO("not implemented")
    }

    override fun getTaskDescription(): String {
        TODO("not implemented")
    }

    override fun getTaskDeadline(): String {
        TODO("not implemented")
    }

    override fun getTaskPriority(): Int {
        TODO("not implemented")
    }

    override fun setTaskTitle(title: String) {
        TODO("not implemented")
    }

    override fun setTaskDescription(description: String) {
        TODO("not implemented")
    }

    override fun setTaskDeadline(deadline: String) {
        TODO("not implemented")
    }

    override fun setTaskPriority(priority: Int) {
        TODO("not implemented")
    }
}
