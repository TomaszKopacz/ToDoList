package com.example.tomas.mytasks.board


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.*
import com.example.tomas.mytasks.R
import com.example.tomas.mytasks.db.entity.Task
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

        ItemTouchHelper(object : SwipeToDeleteCallback(context) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
                if (viewHolder != null) {
                    viewHolder as TaskAdapter.TaskViewHolder
                    presenter.onItemSwiped(viewHolder.getTask(), viewHolder.itemView)
                }
            }
        }).attachToRecyclerView(tasks_list)
    }

    override fun getContext(): Context {
        return activity!!
    }

    override fun showTasks(tasks: LiveData<List<Task>>, listener: TaskAdapter.OnItemClickListener) {
        tasks.observe(this, Observer {
            tasks_list.adapter = TaskAdapter(it!!, listener)
        })
    }
}
