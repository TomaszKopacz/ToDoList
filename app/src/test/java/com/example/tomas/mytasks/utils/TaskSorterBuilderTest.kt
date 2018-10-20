package com.example.tomas.mytasks.utils

import org.junit.Assert.assertTrue
import org.junit.Test

class TaskSorterBuilderTest {

    @Test
    fun checkIfFirstSortFieldIsSet() {
        val builder = TaskSorterBuilder()
        val sorter = builder.firstlySortBy(TaskSorter.PRIORITY).build()

        assertTrue(sorter.getPrimaryField() == TaskSorter.PRIORITY)
        assertTrue(sorter.getSecondaryField() == null)
        assertTrue(sorter.getThirdField() == null)
    }

    @Test
    fun checkIfSecondSortFieldIsSet() {
        val builder = TaskSorterBuilder()
        val sorter = builder.secondlySortBy(TaskSorter.PRIORITY).build()

        assertTrue(sorter.getPrimaryField() == null)
        assertTrue(sorter.getSecondaryField() == TaskSorter.PRIORITY)
        assertTrue(sorter.getThirdField() == null)
    }

    @Test
    fun checkIfThirdSortFieldIsSet() {
        val builder = TaskSorterBuilder()
        val sorter = builder.thirdlySortBy(TaskSorter.PRIORITY).build()

        assertTrue(sorter.getPrimaryField() == null)
        assertTrue(sorter.getSecondaryField() == null)
        assertTrue(sorter.getThirdField() == TaskSorter.PRIORITY)
    }

    @Test
    fun checkIsNoFieldSet() {
        val builder = TaskSorterBuilder()
        val sorter = builder.build()

        assertTrue(sorter.getPrimaryField() == null)
        assertTrue(sorter.getSecondaryField() == null)
        assertTrue(sorter.getThirdField() == null)
    }

    @Test
    fun checkAllFieldsAreSet() {
        val builder = TaskSorterBuilder()
        val sorter = builder
            .firstlySortBy(TaskSorter.PRIORITY)
            .secondlySortBy(TaskSorter.DEADLINE)
            .thirdlySortBy(TaskSorter.CREATION_DATE)
            .build()

        assertTrue(sorter.getPrimaryField() == TaskSorter.PRIORITY)
        assertTrue(sorter.getSecondaryField() == TaskSorter.DEADLINE)
        assertTrue(sorter.getThirdField() == TaskSorter.CREATION_DATE)
    }
}