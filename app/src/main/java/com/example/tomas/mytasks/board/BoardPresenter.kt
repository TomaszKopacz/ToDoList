package com.example.tomas.mytasks.board

interface BoardPresenter : TaskAdapter.OnItemClickListener {
    fun onAddTaskButtonClicked()
}
