package com.example.tomas.mytasks.presenter

import android.content.Context
import com.example.tomas.mytasks.entity.Task
import com.example.tomas.mytasks.presenter.board.OnTaskReadyListener
import com.example.tomas.mytasks.presenter.creator.TaskMakerPresenterImpl
import com.example.tomas.mytasks.view.creator.TaskMakerView
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock


class TaskCreatorPresenterTest {

    private var testPresenter: TaskMakerPresenterImpl? = null
    private var testCreatorView: TaskMakerView? = null
    private var testListener: OnTaskReadyListener? = null

    companion object {
        const val TEST_TITLE = "TEST_TITLE"
        const val TEST_DESCRIPTION = "TEST_DESCRIPTION"
        const val TEST_DEADLINE = "31-12-2020"
        const val TEST_PRIORITY = 4

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
        testCreatorView = object : TaskMakerView {

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
            override fun taskReady(task: Task, id: Int?) {
                createdTask = task
            }
        }
    }

    @Test
    fun testCreatingTask() {
        testPresenter = TaskMakerPresenterImpl(testCreatorView!!)

        testCreatorView!!.setTaskTitle(TEST_TITLE)
        testCreatorView!!.setTaskDescription(TEST_DESCRIPTION)
        testCreatorView!!.setTaskDeadline(TEST_DEADLINE)
        testCreatorView!!.setTaskPriority(TEST_PRIORITY)

        testPresenter!!.createTask(testListener!!)
        testPresenter!!.onSubmitTaskButtonClicked()

        assertTrue(createdTask!!.id == null)
        assertTrue(createdTask!!.title == TEST_TITLE)
        assertTrue(createdTask!!.description == TEST_DESCRIPTION)
        assertTrue(createdTask!!.deadline == TEST_DEADLINE)
        assertTrue(createdTask!!.priority == TEST_PRIORITY)
        assertFalse(createdTask!!.creationDate!!.isEmpty())
    }

    @Test
    fun testCreatingTaskWhenEmptyFields() {
        testPresenter = TaskMakerPresenterImpl(testCreatorView!!)

        testCreatorView!!.setTaskTitle(EMPTY_TEXT)
        testCreatorView!!.setTaskDescription(EMPTY_TEXT)
        testCreatorView!!.setTaskDeadline(EMPTY_TEXT)
        testCreatorView!!.setTaskPriority(TEST_PRIORITY)

        testPresenter!!.createTask(testListener!!)
        testPresenter!!.onSubmitTaskButtonClicked()

        assertTrue(createdTask!!.id == null)
        assertTrue(createdTask!!.title == EMPTY_TEXT)
        assertTrue(createdTask!!.description == EMPTY_TEXT)
        assertTrue(createdTask!!.deadline == EMPTY_TEXT)
        assertTrue(createdTask!!.priority == TEST_PRIORITY)
        assertFalse(createdTask!!.creationDate!!.isEmpty())
    }

    @Test
    fun testLoadingTask(){
        testPresenter = TaskMakerPresenterImpl(testCreatorView!!)

        val testTask = Task()
        testTask.title = TEST_TITLE
        testTask.description = TEST_DESCRIPTION
        testTask.deadline = TEST_DEADLINE
        testTask.priority = TEST_PRIORITY

        testPresenter!!.modifyTask(testTask, 0, testListener!!)

        assertTrue(testCreatorView!!.getTaskTitle() == TEST_TITLE)
        assertTrue(testCreatorView!!.getTaskDescription() == TEST_DESCRIPTION)
        assertTrue(testCreatorView!!.getTaskDeadline() == TEST_DEADLINE)
        assertTrue(testCreatorView!!.getTaskPriority() == TEST_PRIORITY)
    }

    @Test
    fun testLoadingNullTask(){
        testPresenter = TaskMakerPresenterImpl(testCreatorView!!)

        testPresenter!!.modifyTask(Task(), 0, testListener!!)

        assertTrue(testCreatorView!!.getTaskTitle() == EMPTY_TEXT)
        assertTrue(testCreatorView!!.getTaskDescription() == EMPTY_TEXT)
        assertTrue(testCreatorView!!.getTaskDeadline() == EMPTY_TEXT)
        assertTrue(testCreatorView!!.getTaskPriority() == DEFAULT_PRIORITY)
    }

    @Test
    fun testModifyingTask(){
        testPresenter = TaskMakerPresenterImpl(testCreatorView!!)

        val testTask = Task()
        testTask.title = TEST_TITLE
        testTask.description = TEST_DESCRIPTION
        testTask.deadline = TEST_DEADLINE
        testTask.priority = TEST_PRIORITY

        testPresenter!!.modifyTask(testTask, 0, testListener!!)

        testCreatorView!!.setTaskTitle(EMPTY_TEXT)
        testCreatorView!!.setTaskDescription(EMPTY_TEXT)
        testCreatorView!!.setTaskDeadline(EMPTY_TEXT)
        testCreatorView!!.setTaskPriority(DEFAULT_PRIORITY)

        testPresenter!!.onSubmitTaskButtonClicked()

        assertTrue(testCreatorView!!.getTaskTitle() == EMPTY_TEXT)
        assertTrue(testCreatorView!!.getTaskDescription() == EMPTY_TEXT)
        assertTrue(testCreatorView!!.getTaskDeadline() == EMPTY_TEXT)
        assertTrue(testCreatorView!!.getTaskPriority() == DEFAULT_PRIORITY)
    }
}