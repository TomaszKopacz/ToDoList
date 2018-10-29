package com.example.tomas.mytasks.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tomas.mytasks.R
import com.example.tomas.mytasks.entity.Task
import com.example.tomas.mytasks.presenter.BoardPresenter
import kotlinx.android.synthetic.main.task_item.view.*

class TaskAdapter (private val presenter: BoardPresenter) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)

        view.setOnClickListener{
            presenter.onTaskClicked(view)
        }

        view.setOnLongClickListener{
            presenter.onTaskLongClicked(view)
            true
        }

        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return presenter.getTasksCount()
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        presenter.onItemBoundAtPosition(holder, position)
    }

    fun setContent(holder: TaskViewHolder, task: Task){
        holder.itemView.item_title.text = task.title
        holder.itemView.item_description.text = task.description
        holder.itemView.item_deadline.text = task.deadline
    }

    inner class TaskViewHolder (itemView: View)
        : RecyclerView.ViewHolder(itemView)
}