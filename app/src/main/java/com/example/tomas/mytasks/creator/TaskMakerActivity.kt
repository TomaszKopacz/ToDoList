package com.example.tomas.mytasks.creator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tomas.mytasks.R
import com.example.tomas.mytasks.R.layout.activity_task_maker
import com.example.tomas.mytasks.app.MyNotesApp
import com.example.tomas.mytasks.db.TasksRepositoryImpl
import javax.inject.Inject

class TaskMakerActivity : AppCompatActivity() {

    private var fragment: TaskMakerFragment? = null
    private var presenter: TaskMakerPresenter? = null
    @Inject lateinit var repository: TasksRepositoryImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_task_maker)

        injectDependencies()
        setUpInitFragment()
    }

    private fun injectDependencies() {
        (applicationContext as MyNotesApp).component.inject(this)
    }

    private fun setUpInitFragment() {
        getFragmentInstance()
        setFragmentPresenter()
    }

    private fun getFragmentInstance() {
        fragment = supportFragmentManager.findFragmentById(R.id.task_maker_fragment) as TaskMakerFragment

        if (fragment == null)
            createNewFragment()
    }

    private fun createNewFragment() {
        fragment = TaskMakerFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.task_maker_fragment, fragment)
        transaction.commit()
    }

    private fun setFragmentPresenter() {
        presenter = TaskMakerPresenterImpl(fragment!!, repository)
        fragment!!.setPresenter(presenter!!)
    }
}
