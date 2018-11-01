package com.example.tomas.mytasks.presenter.board

import android.content.Intent
import android.view.View
import com.example.tomas.mytasks.entity.Task
import com.example.tomas.mytasks.view.board.BoardView
import com.example.tomas.mytasks.view.adapter.TaskAdapter
import com.example.tomas.mytasks.view.creator.TaskMakerActivity

class BoardPresenterImpl(private val view: BoardView) : BoardPresenter, TaskAdapter.OnItemClickListener{

    override fun onItemClick(task: Task, itemView: View) {

    }

    override fun onAddTaskButtonClicked() {
        val intent = Intent(view.getContext(), TaskMakerActivity::class.java)
        view.getContext().startActivity(intent)
    }
}