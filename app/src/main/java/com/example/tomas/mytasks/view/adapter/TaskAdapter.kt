package com.example.tomas.mytasks.view.adapter

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tomas.mytasks.R
import com.example.tomas.mytasks.entity.Task
import kotlinx.android.synthetic.main.task_item.view.*

class TaskAdapter(private val tasks: List<Task>,
                  private val listener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(task: Task, itemView: View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_item, parent, false)

        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TaskViewHolder).bind(tasks[position], listener)
    }


    override fun getItemCount(): Int {
        return tasks.size
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var currentTask: Task? = null

        fun bind(task: Task, listener: OnItemClickListener?) = with(itemView) {

            currentTask = task

            setLayout(this, task)

            setOnClickListener {
                listener?.onItemClick(task, it)
            }
        }

        private fun setLayout(view: View, task: Task){
            view.item_title.text = task.title
            view.item_description.text = task.description
            view.item_deadline.text = task.deadline
            view.setBackgroundColor(getBackgroundColor(task))
        }

        private fun getBackgroundColor(task: Task) : Int {
            return when (task.priority) {
                0 -> Color.parseColor("#ffffff")
                1 -> Color.parseColor("#d4e157")
                2 -> Color.parseColor("#ffee58")
                3 -> Color.parseColor("#ffca28")
                4 -> Color.parseColor("#ffa726")
                5 -> Color.parseColor("#ff7043")
                6 -> Color.parseColor("#ef5350")
                else -> Color.parseColor("#ffffff")
            }
        }

        fun getTask(): Task {
            return currentTask!!
        }
    }
}