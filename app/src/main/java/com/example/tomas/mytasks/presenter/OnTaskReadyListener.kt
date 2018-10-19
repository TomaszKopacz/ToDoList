package com.example.tomas.mytasks.presenter

import com.example.tomas.mytasks.entity.Task

interface OnTaskReadyListener {
    fun taskReady(task : Task)
}