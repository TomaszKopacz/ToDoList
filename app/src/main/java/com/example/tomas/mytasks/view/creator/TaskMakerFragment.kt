package com.example.tomas.mytasks.view.creator


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.example.tomas.mytasks.R
import com.example.tomas.mytasks.presenter.creator.TaskMakerPresenter
import com.example.tomas.mytasks.presenter.creator.TaskMakerPresenterImpl
import kotlinx.android.synthetic.main.fragment_task_maker.*

class TaskMakerFragment : Fragment(), TaskMakerView {

    private var presenter: TaskMakerPresenter? = null

    companion object {
        const val EMPTY_TEXT : String = ""
        const val DEFAULT_PRIORITY = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task_maker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = TaskMakerPresenterImpl(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_task_maker, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_submit -> {
                presenter!!.onSubmitTaskButtonClicked()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun getContext(): Context {
        return activity!!
    }

    override fun getTaskTitle(): String {
        return task_title.text.toString()
    }

    override fun getTaskDescription(): String {
        return task_description.text.toString()
    }

    override fun getTaskDeadline(): String {
        return task_deadline.text.toString()
    }

    override fun getTaskPriority(): Int {
        return priority_bar.progress
    }

    override fun setTaskTitle(title: String?) {
        if (title == null)
            task_title.setText(EMPTY_TEXT)
        else
            task_title.setText(title)
    }

    override fun setTaskDescription(description: String?) {
        if (description == null)
            task_title.setText(EMPTY_TEXT)
        else
            task_title.setText(description)
    }

    override fun setTaskDeadline(deadline: String?) {
        if (deadline == null)
            task_title.setText(EMPTY_TEXT)
        else
            task_title.setText(deadline)
    }

    override fun setTaskPriority(priority: Int?) {
        if (priority == null)
            priority_bar.progress = DEFAULT_PRIORITY
        else
            priority_bar.progress = priority
    }
}
