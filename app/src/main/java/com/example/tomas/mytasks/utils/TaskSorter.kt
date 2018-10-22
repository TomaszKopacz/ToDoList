package com.example.tomas.mytasks.utils

import com.example.tomas.mytasks.entity.Task
import java.text.SimpleDateFormat
import java.util.*


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

    private var leftPointer: Int = 0
    private var rightPointer: Int = 0
    private var thresholdTask: Task? = null

    private fun quickSort(tasks: Array<Task>, begin: Int, end: Int) {

        leftPointer = begin
        rightPointer = end
        thresholdTask = tasks[(begin + end) / 2]

        do {
            movePointersUntilExchangeIsNeeded(tasks, begin, end)
            exchangeTasks(tasks, leftPointer, rightPointer)
            leftPointer++
            rightPointer--

        } while (leftPointer <= rightPointer)

        if (begin < rightPointer)
            quickSort(tasks, begin, rightPointer)
        if (leftPointer < end)
            quickSort(tasks, leftPointer, end)
    }

    private fun movePointersUntilExchangeIsNeeded(tasks: Array<Task>, begin: Int, end: Int){
        leftPointer = begin
        rightPointer = end

        val middle = (begin + end) / 2
        thresholdTask = tasks[middle]

        while (isSecondTaskMoreImportant(tasks[leftPointer], thresholdTask!!) && leftPointer < middle)
            leftPointer++
        while (isSecondTaskMoreImportant(thresholdTask!!, tasks[rightPointer]) && rightPointer > middle)
            rightPointer--
    }

    private fun exchangeTasks(tasks: Array<Task>, leftPointer: Int, rightPointer: Int) {
        val temp = tasks[leftPointer]
        tasks[leftPointer] = tasks[rightPointer]
        tasks[rightPointer] = temp
    }

    private fun isSecondTaskMoreImportant(task1: Task, task2: Task): Boolean {
        return isSecondTaskMoreImportantByPrimaryFields(task1, task2)
    }

    private fun isSecondTaskMoreImportantByPrimaryFields(task1: Task, task2: Task): Boolean {
        return if (primaryField == null)
            isSecondTaskMoreImportantBySecondlFields(task1, task2)
        else {
            val result = compareFields(task1, task2, primaryField!!)
            when (result) {
                FIELD_ONE_IS_GREATER -> false
                FIELDS_ARE_THE_SAME -> isSecondTaskMoreImportantBySecondlFields(task1, task2)
                else -> true
            }
        }
    }

    private fun isSecondTaskMoreImportantBySecondlFields(task1: Task, task2: Task): Boolean {
        return if (secondaryField == null)
            isSecondTaskMoreImportantByThirdFields(task1, task2)
        else {
            val result = compareFields(task1, task2, secondaryField!!)
            when (result) {
                FIELD_ONE_IS_GREATER -> false
                FIELDS_ARE_THE_SAME -> isSecondTaskMoreImportantByThirdFields(task1, task2)
                else -> true
            }
        }
    }

    private fun isSecondTaskMoreImportantByThirdFields(task1: Task, task2: Task): Boolean {
        return if (thirdField == null)
            return true
        else {
            val result = compareFields(task1, task2, thirdField!!)
            when (result) {
                FIELD_ONE_IS_GREATER -> false
                else -> true
            }
        }
    }

    private fun compareFields(task1: Task, task2: Task, field: String): Int {
        return when (field) {
            PRIORITY -> comparePriorities(task1, task2)
            DEADLINE -> compareDeadlines(task1, task2)
            else -> compareCreationDates(task1, task2)
        }
    }

    private fun comparePriorities(task1: Task, task2: Task): Int {
        return when {
            task1.priority!! > task2.priority!! -> FIELD_ONE_IS_GREATER
            task1.priority!! < task2.priority!! -> FIELD_TWO_IS_GREATER
            else -> FIELDS_ARE_THE_SAME
        }
    }

    private fun compareDeadlines(task1: Task, task2: Task): Int {
        val deadline1 = SimpleDateFormat(DatePatterns.DD_MM_YYYY_DASHES, Locale.getDefault()).parse(task1.deadline)
        val deadline2 = SimpleDateFormat(DatePatterns.DD_MM_YYYY_DASHES, Locale.getDefault()).parse(task2.deadline)

        return when {
            deadline1 < deadline2 -> FIELD_ONE_IS_GREATER
            deadline1 > deadline2 -> FIELD_TWO_IS_GREATER
            else -> FIELDS_ARE_THE_SAME
        }
    }

    private fun compareCreationDates(task1: Task, task2: Task): Int {
        val date1 = SimpleDateFormat(DatePatterns.DD_MM_YYYY_DASHES, Locale.getDefault()).parse(task1.creationDate)
        val date2 = SimpleDateFormat(DatePatterns.DD_MM_YYYY_DASHES, Locale.getDefault()).parse(task2.creationDate)

        return when {
            date1 < date2 -> FIELD_ONE_IS_GREATER
            date1 > date2 -> FIELD_TWO_IS_GREATER
            else -> FIELDS_ARE_THE_SAME
        }
    }
}