package com.example.tomas.mytasks.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tomas.mytasks.R
import com.example.tomas.mytasks.entity.Task
import kotlinx.android.synthetic.main.task_item.view.*

class TaskAdapter(
    private val tasks: List<Task>,
    private val listener: OnItemClickListener
)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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

    inner class TaskViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(task: Task, listener: OnItemClickListener) = with(itemView){
            item_title.text = task.title
            item_description.text = task.description
            item_deadline.text = task.deadline

            setOnClickListener {
                listener.onItemClick(task, it)
            }
        }
    }
}