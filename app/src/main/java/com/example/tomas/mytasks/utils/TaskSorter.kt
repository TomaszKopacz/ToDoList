package com.example.tomas.mytasks.utils

import com.example.tomas.mytasks.entity.Task

class TaskSorter {

    companion object {
        const val CREATION_DATE = "CREATION_DATE"
        const val DEADLINE = "DEADLINE"
        const val PRIORITY = "PRIORITY"
    }

    private var primaryField: String? = null
    private var secondaryField: String? = null
    private var thirdField: String? = null

    fun setPrimaryField(primaryField: String) {
        this.primaryField = primaryField
    }

    fun setSecondaryField(secondaryField: String) {
        this.secondaryField = secondaryField
    }

    fun setThirdField(thirdField: String) {
        this.thirdField = thirdField
    }

    fun getPrimaryField() : String? {
        return primaryField
    }

    fun getSecondaryField() : String? {
        return secondaryField
    }

    fun getThirdField() : String? {
        return thirdField
    }

    fun sort(tasksToSort: List<Task>): List<Task> {
        TODO("not implemented")
    }
}