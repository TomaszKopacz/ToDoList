package com.example.tomas.mytasks.utils

import com.example.tomas.mytasks.entity.Task


class TaskSorter {

    companion object {
        const val CREATION_DATE = "CREATION_DATE"
        const val DEADLINE = "DEADLINE"
        const val PRIORITY = "PRIORITY"

        private const val FIELD_ONE_IS_GREATER = -1
        private const val FIELDS_ARE_THE_SAME = 0
        private const val FIELD_TWO_IS_GREATER = 1
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

    fun getPrimaryField(): String? {
        return primaryField
    }

    fun getSecondaryField(): String? {
        return secondaryField
    }

    fun getThirdField(): String? {
        return thirdField
    }

    fun sort(tasksToSort: Array<Task>): Array<Task> {
        quickSort(tasksToSort, 0, tasksToSort.size - 1)
        return tasksToSort
    }

    private fun quickSort(tasks: Array<Task>, x: Int, y: Int) {

        var i: Int = x
        var j: Int = y
        var temp: Task
        val v: Task = tasks[(x + y) / 2]

        do {
            while (comparePriorities(tasks[i], v))
                i++
            while (comparePriorities(v, tasks[j]))
                j--
            if (i <= j) {
                temp = tasks[i]
                tasks[i] = tasks[j]
                tasks[j] = temp
                i++
                j--
            }
        } while (i <= j)
        if (x < j)
            quickSort(tasks, x, j)
        if (i < y)
            quickSort(tasks, i, y)
    }

    private fun comparePriorities(task1: Task, task2: Task): Boolean {
        return task1.priority!! > task2.priority!!
    }
}