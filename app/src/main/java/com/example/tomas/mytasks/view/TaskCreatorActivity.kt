package com.example.tomas.mytasks.view

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tomas.mytasks.R.layout.activity_task_creator
import com.example.tomas.mytasks.presenter.TaskCreator
import kotlinx.android.synthetic.main.activity_task_creator.*

class TaskCreatorActivity : AppCompatActivity(), TaskView {

    var presenter: TaskCreator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_task_creator)

        submit_task_button.setOnClickListener {
            presenter?.createTask()
        }
    }

    override fun getContext(): Context {
        return getContext()
    }

    override fun getTaskTitle(): String {
        return task_title.text.toString()
    }

    override fun getTaskDescription(): String {
        return task_description.text.toString()
    }

    override fun getTaskDeadline(): String {
        return task_deadline.text.toString()
    }

    override fun getTaskPriority(): Int {
        return priority_bar.progress
    }

    override fun setTaskTitle(title: String) {
        task_title.setText(title)
    }

    override fun setTaskDescription(description: String) {
        task_description.setText(description)
    }

    override fun setTaskDeadline(deadline: String) {
        task_deadline.setText(deadline)
    }

    override fun setTaskPriority(priority: Int) {
        priority_bar.progress = priority
    }
}
