package com.example.tomas.mytasks.view

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tomas.mytasks.R
import com.example.tomas.mytasks.presenter.TaskCreator

class TaskCreatorActivity(presenter: TaskCreator) : AppCompatActivity(), TaskView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_creator)
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

    override fun getDeadline(): String {
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
