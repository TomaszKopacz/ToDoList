package com.example.tomas.mytasks.board

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tomas.mytasks.R
import com.example.tomas.mytasks.db.entity.Task
import kotlinx.android.synthetic.main.task_item.view.*

class TaskAdapter(private val tasks: List<Task>,
                  private val listener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(task: Task, itemView: View)
        fun onItemLongClick(task: Task, itemView: View?)
        fun onItemSwiped(task: Task, itemView: View)
        fun onTitleLongClick(task: Task, itemView: View?)
        fun onDeadlineLongClick(task: Task, itemView: View?)
        fun onDescriptionLongClick(task: Task, itemView: View?)
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

            if (listener != null)
                setListener(this, listener, task)
        }

        private fun setLayout(view: View, task: Task){
            view.item_title.text = task.title
            view.item_description.text = task.description
            view.item_deadline.text = (view.context.getString(R.string.datetime, task.deadline, task.time)).trim()
            view.setBackgroundColor(getBackgroundColor(task))
        }

        private fun getBackgroundColor(task: Task) : Int {
            return when (task.priority) {
                0 -> Color.parseColor("#ffffff")
                1 -> Color.parseColor("#dce775")
                2 -> Color.parseColor("#fff176")
                3 -> Color.parseColor("#ffd54f")
                4 -> Color.parseColor("#ffb74d")
                5 -> Color.parseColor("#ff8a65")
                6 -> Color.parseColor("#e57373")
                else -> Color.parseColor("#ffffff")
            }
        }

        private fun setListener(view: View, listener: OnItemClickListener, task: Task){
            view.setOnClickListener {
                updateLayoutWhenItemClicked(it)
                listener.onItemClick(task, it)
            }

            view.setOnLongClickListener {
                listener.onItemLongClick(task, it)
                true
            }

            view.item_title.setOnLongClickListener {
                listener.onTitleLongClick(task, it)
                true
            }

            view.item_deadline.setOnLongClickListener {
                listener.onDeadlineLongClick(task, it)
                true
            }

            view.item_description.setOnLongClickListener {
                listener.onDescriptionLongClick(task, it)
                true
            }
        }

        private fun updateLayoutWhenItemClicked(view: View){
            view.item_expandable.toggle()
        }

        fun getTask(): Task {
            return currentTask!!
        }
    }
}