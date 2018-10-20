package com.example.tomas.mytasks.presenter

import android.content.Context
import com.example.tomas.mytasks.entity.Task
import com.example.tomas.mytasks.view.TaskView
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock


class TaskCreatorPresenterTest {

    private var testPresenter: TaskCreatorPresenter? = null
    private var testCreatorView: TaskView? = null
    private var testListener: OnTaskReadyListener? = null

    companion object {
        const val TITLE = "TITLE"
        const val DESCRIPTION = "DESCRIPTION"
        const val DEADLINE = "31-12-2020"
        const val PRIORITY = 4
        const val EMPTY_TEXT = ""
    }

    var testTitle: String? = null
    var testDescription: String? = null
    var testDeadline: String? = null
    var testPriority: Int? = null
    var taskCreated: Task? = null

    @Before
    fun createTaskCreatorView() {
        testCreatorView = object : TaskView {

            override fun getContext(): Context {
                return mock(Context::class.java)
            }

            override fun getTaskTitle(): String {
                return testTitle!!
            }

            override fun getTaskDescription(): String {
                return testDescription!!
            }

            override fun getTaskDeadline(): String {
                return testDeadline!!
            }

            override fun getTaskPriority(): Int {
                return testPriority!!
            }

            override fun setTaskTitle(title: String) {
                testTitle = title
            }

            override fun setTaskDescription(description: String) {
                testDescription = description
            }

            override fun setTaskDeadline(deadline: String) {
                testDeadline = deadline
            }

            override fun setTaskPriority(priority: Int) {
                testPriority = priority
            }
        }
    }

    @Before
    fun createOnTaskReadyListener() {
        testListener = object : OnTaskReadyListener {
            override fun taskReady(task: Task) {
                taskCreated = task
            }
        }
    }

    @Test
    fun testCreatingTask() {
        testPresenter = TaskCreatorPresenter(testCreatorView!!, testListener!!)
        testCreatorView!!.setTaskTitle(TITLE)
        testCreatorView!!.setTaskDescription(DESCRIPTION)
        testCreatorView!!.setTaskDeadline(DEADLINE)
        testCreatorView!!.setTaskPriority(PRIORITY)

        testPresenter!!.createTask()

        assertTrue(taskCreated!!.id == null)
        assertTrue(taskCreated!!.title == TITLE)
        assertTrue(taskCreated!!.description == DESCRIPTION)
        assertTrue(taskCreated!!.deadline == DEADLINE)
        assertTrue(taskCreated!!.priority == PRIORITY)
        assertFalse(taskCreated!!.creationDate!!.isNullOrEmpty())
    }

    @Test
    fun testCreatingTaskWhenEmptyFields() {
        testPresenter = TaskCreatorPresenter(testCreatorView!!, testListener!!)
        testCreatorView!!.setTaskTitle(EMPTY_TEXT)
        testCreatorView!!.setTaskDescription(EMPTY_TEXT)
        testCreatorView!!.setTaskDeadline(EMPTY_TEXT)
        testCreatorView!!.setTaskPriority(PRIORITY)

        testPresenter!!.createTask()

        assertTrue(taskCreated!!.id == null)
        assertTrue(taskCreated!!.title == EMPTY_TEXT)
        assertTrue(taskCreated!!.description == EMPTY_TEXT)
        assertTrue(taskCreated!!.deadline == EMPTY_TEXT)
        assertTrue(taskCreated!!.priority == PRIORITY)
        assertFalse(taskCreated!!.creationDate!!.isNullOrEmpty())
    }
}