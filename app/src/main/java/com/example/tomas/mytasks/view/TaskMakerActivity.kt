package com.example.tomas.mytasks.view

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tomas.mytasks.R.layout.activity_task_creator
import com.example.tomas.mytasks.presenter.TaskMakerPresenter
import kotlinx.android.synthetic.main.activity_task_creator.*

class TaskMakerActivity : AppCompatActivity(), TaskMakerView {

    private var presenter: TaskMakerPresenter? = null

    companion object {
        const val EMPTY_TEXT : String = ""
        const val DEFAULT_PRIORITY = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_task_creator)

        submit_task_button.setOnClickListener {
            presenter?.onSubmitTaskButtonClicked()
        }
    }

    override fun setPresenter(presenter: TaskMakerPresenter) {
        this.presenter = presenter
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

    override fun setTaskTitle(title: String?) {
        if (title == null)
            task_title.setText(EMPTY_TEXT)
        else
            task_title.setText(title)
    }

    override fun setTaskDescription(description: String?) {
        if (description == null)
            task_title.setText(EMPTY_TEXT)
        else
            task_title.setText(description)
    }

    override fun setTaskDeadline(deadline: String?) {
        if (deadline == null)
            task_title.setText(EMPTY_TEXT)
        else
            task_title.setText(deadline)
    }

    override fun setTaskPriority(priority: Int?) {
        if (priority == null)
            priority_bar.progress = DEFAULT_PRIORITY
        else
            priority_bar.progress = priority
    }
}
