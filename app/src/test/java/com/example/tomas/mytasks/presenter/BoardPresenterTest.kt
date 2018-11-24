package com.example.tomas.mytasks.presenter

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.view.View
import com.example.tomas.mytasks.board.BoardPresenterImpl
import com.example.tomas.mytasks.board.BoardView
import com.example.tomas.mytasks.db.TasksRepository
import com.example.tomas.mytasks.db.entity.Task
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class BoardPresenterTest {

    private var testPresenter: BoardPresenterImpl? = null
    @Mock private var testRepository: TasksRepository? = null
    @Mock private var testBoardView: BoardView? = null

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testLoadTasksWhenCreated() {
        val tasks = MutableLiveData<List<Task>>()
        Mockito.`when`(testRepository!!.getAllTasks()).thenReturn(tasks)

        testPresenter = BoardPresenterImpl(testBoardView!!, testRepository!!)
        verify(testRepository!!).getAllTasks()
        verify(testBoardView!!).showTasks(tasks, testPresenter!!)
    }

    @Test
    fun testOnItemClick() {
        val task = Task()
        val itemView = View(Application.con)
        testPresenter!!.onItemClick(task, itemView)
    }
}