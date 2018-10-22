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
        const val DEFAULT_PRIORITY = 1
    }

    var testTitle: String? = null
    var testDescription: String? = null
    var testDeadline: String? = null
    var testPriority: Int? = null
    var createdTask: Task? = null

    @Before
    fun createTaskCreatorView() {
        testCreatorView = object : TaskView {

            override fun getContext(): Context {
                return mock(Context::class.java)
            }

            override fun getTaskTitle(): String {
                return if (testTitle == null) EMPTY_TEXT else testTitle!!
            }

            override fun getTaskDescription(): String {
                return if (testDescription == null) EMPTY_TEXT else testDescription!!
            }

            override fun getTaskDeadline(): String {
                return if (testDeadline == null) EMPTY_TEXT else testDeadline!!
            }

            override fun getTaskPriority(): Int {
                return if (testPriority == null) DEFAULT_PRIORITY else testPriority!!
            }

            override fun setTaskTitle(title: String?) {
                testTitle = title ?: EMPTY_TEXT
            }

            override fun setTaskDescription(description: String?) {
                testDescription = description ?: EMPTY_TEXT
            }

            override fun setTaskDeadline(deadline: String?) {
                testDeadline = deadline ?: EMPTY_TEXT
            }

            override fun setTaskPriority(priority: Int?) {
                testPriority = priority ?: DEFAULT_PRIORITY
            }
        }
    }

    @Before
    fun createOnTaskReadyListener() {
        testListener = object : OnTaskReadyListener {
            override fun taskReady(task: Task) {
                createdTask = task
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

        assertTrue(createdTask!!.id == null)
        assertTrue(createdTask!!.title == TITLE)
        assertTrue(createdTask!!.description == DESCRIPTION)
        assertTrue(createdTask!!.deadline == DEADLINE)
        assertTrue(createdTask!!.priority == PRIORITY)
        assertFalse(createdTask!!.creationDate!!.isEmpty())
    }

    @Test
    fun testCreatingTaskWhenEmptyFields() {
        testPresenter = TaskCreatorPresenter(testCreatorView!!, testListener!!)
        testCreatorView!!.setTaskTitle(EMPTY_TEXT)
        testCreatorView!!.setTaskDescription(EMPTY_TEXT)
        testCreatorView!!.setTaskDeadline(EMPTY_TEXT)
        testCreatorView!!.setTaskPriority(PRIORITY)

        testPresenter!!.createTask()

        assertTrue(createdTask!!.id == null)
        assertTrue(createdTask!!.title == EMPTY_TEXT)
        assertTrue(createdTask!!.description == EMPTY_TEXT)
        assertTrue(createdTask!!.deadline == EMPTY_TEXT)
        assertTrue(createdTask!!.priority == PRIORITY)
        assertFalse(createdTask!!.creationDate!!.isEmpty())
    }

    @Test
    fun testLoadingTask(){
        testPresenter = TaskCreatorPresenter(testCreatorView!!, testListener)

        val testTask = Task()
        testTask.title = TITLE
        testTask.description = DESCRIPTION
        testTask.deadline = DEADLINE
        testTask.priority = PRIORITY

        testPresenter!!.loadTask(testTask)

        assertTrue(testCreatorView!!.getTaskTitle() == TITLE)
        assertTrue(testCreatorView!!.getTaskDescription() == DESCRIPTION)
        assertTrue(testCreatorView!!.getTaskDeadline() == DEADLINE)
        assertTrue(testCreatorView!!.getTaskPriority() == PRIORITY)
    }

}