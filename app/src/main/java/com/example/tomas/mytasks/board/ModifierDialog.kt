package com.example.tomas.mytasks.board

import android.app.AlertDialog
import android.content.Context
import android.support.design.widget.TextInputLayout
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.SeekBar
import com.example.tomas.mytasks.R
import com.example.tomas.mytasks.db.entity.Task

class ModifierDialog(private val context: Context, private val presenter: ModifierDialogPresenter) {

    private var dialog: AlertDialog.Builder? = null

    private var taskToModify: Task? = null

    private var titleView: TextInputLayout? = null
    private var descriptionView: TextInputLayout? = null
    private var dateView: TextInputLayout? = null
    private var timeView: TextInputLayout? = null
    private var priorityView: SeekBar? = null

    fun show(task: Task) {
        dialog = AlertDialog.Builder(context)
        inflateLayout(context)
        setTask(task)
        dialog?.show()
    }

    private fun inflateLayout(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.dialog_modifier, LinearLayout(context))
        getFields(view)
        setDialogLayout(view)
    }

    private fun getFields(view: View) {
        titleView = view.findViewById(R.id.task_title_dialog)
        descriptionView = view.findViewById(R.id.task_description_dialog)
        dateView = view.findViewById(R.id.task_date_dialog)
        timeView = view.findViewById(R.id.task_time_dialog)
        priorityView = view.findViewById(R.id.priority_bar_dialog)
    }

    private fun setDialogLayout(view: View?) {
        dialog?.setView(view)
        dialog?.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
            presenter.onTaskModified(getTask())
        }
        dialog?.setNegativeButton("CANCEL") { dialog, _ ->
            dialog.dismiss()
        }
    }

    private fun getTask() : Task {

        if (taskToModify == null){
            taskToModify = Task()

        } else {
            taskToModify!!.title = titleView!!.editText!!.text.toString()
            taskToModify!!.description = descriptionView!!.editText!!.text.toString()
            taskToModify!!.deadline = dateView!!.editText!!.text.toString()
            taskToModify!!.time = timeView!!.editText!!.text.toString()
            taskToModify!!.priority = priorityView!!.progress
        }

        return taskToModify!!
    }

    private fun setTask(task: Task) {
        taskToModify = task

        titleView?.editText!!.setText(taskToModify!!.title)
        descriptionView?.editText!!.setText(taskToModify!!.description)
        dateView?.editText!!.setText(taskToModify!!.deadline)
        timeView?.editText!!.setText(taskToModify!!.time)
        priorityView?.progress = taskToModify!!.priority
    }
}