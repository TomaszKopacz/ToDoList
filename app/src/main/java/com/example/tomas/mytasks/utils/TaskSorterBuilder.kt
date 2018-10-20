package com.example.tomas.mytasks.utils

class TaskSorterBuilder {

    private var taskSorter: TaskSorter? = null

    fun firstlySortBy(primaryField: String): TaskSorterBuilder {
        createSorterIfNeeded()
        taskSorter!!.setPrimaryField(primaryField)

        return this
    }

    fun secondlySortBy(secondaryField: String): TaskSorterBuilder {
        createSorterIfNeeded()
        taskSorter!!.setSecondaryField(secondaryField)

        return this
    }

    fun thirdlySortBy(thirdField: String): TaskSorterBuilder {
        createSorterIfNeeded()
        taskSorter!!.setThirdField(thirdField)

        return this
    }

    private fun createSorterIfNeeded() {
        if (taskSorter == null)
            taskSorter = TaskSorter()
    }

    fun build(): TaskSorter {
        return if (taskSorter == null) TaskSorter() else taskSorter!!
    }
}