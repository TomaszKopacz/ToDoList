package com.example.tomas.mytasks.board


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.*
import com.example.tomas.mytasks.R
import kotlinx.android.synthetic.main.fragment_board.*

class BoardFragment : Fragment(), BoardView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_board, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_board, menu)
    }

    override fun setPresenter(presenter: BoardPresenter) {
        add_task_fab.setOnClickListener {
            presenter.onAddTaskButtonClicked()
        }
    }

    override fun getContext(): Context {
        return activity!!
    }

    override fun showTasks(adapter: TaskAdapter) {
        tasks_list.adapter = adapter
    }

    override fun setOnItemTouchNotifier(callback: ItemTouchHelper.SimpleCallback) {
        ItemTouchHelper(callback).attachToRecyclerView(tasks_list)
    }
}
