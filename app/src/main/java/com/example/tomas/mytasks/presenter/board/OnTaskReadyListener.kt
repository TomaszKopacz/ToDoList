package com.example.tomas.mytasks.presenter.board

import com.example.tomas.mytasks.entity.Task

interface OnTaskReadyListener {
    fun taskReady(task : Task, id: Int?)
}