package com.example.tomas.mytasks.board

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tomas.mytasks.R
import com.example.tomas.mytasks.app.MyNotesApp
import com.example.tomas.mytasks.db.TasksRepositoryImpl
import javax.inject.Inject


class BoardActivity : AppCompatActivity() {

    private var boardFragment: BoardFragment? = null
    private var boardPresenter: BoardPresenter? = null
    @Inject lateinit var repository: TasksRepositoryImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

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
        boardFragment = supportFragmentManager.findFragmentById(R.id.task_maker_fragment) as BoardFragment

        if (boardFragment == null)
            createNewFragment()
    }

    private fun createNewFragment(){
        boardFragment = BoardFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.task_maker_fragment, boardFragment)
        transaction.commit()
    }

    private fun setFragmentPresenter() {
        boardPresenter = BoardPresenterImpl(boardFragment!!, repository)
        boardFragment!!.setPresenter(boardPresenter!!)
    }
}
