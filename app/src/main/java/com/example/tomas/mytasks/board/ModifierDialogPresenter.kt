package com.example.tomas.mytasks.board

import com.example.tomas.mytasks.db.entity.Task

interface ModifierDialogPresenter {
    fun onTaskModified(task: Task)
}
