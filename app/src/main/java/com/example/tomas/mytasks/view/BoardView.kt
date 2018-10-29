package com.example.tomas.mytasks.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import com.example.tomas.mytasks.presenter.BoardPresenter

interface BoardView {

    fun getContext() : Context
    fun setPresenter(presenter: BoardPresenter)

    fun displayTasks(adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>)
}