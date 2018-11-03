package com.example.tomas.mytasks.view.creator


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.example.tomas.mytasks.R
import com.example.tomas.mytasks.presenter.creator.TaskMakerPresenter
import com.example.tomas.mytasks.presenter.creator.TaskMakerPresenterImpl
import kotlinx.android.synthetic.main.fragment_task_maker.*
import java.util.*

class TaskMakerFragment : Fragment(), TaskMakerView {

    private var presenter: TaskMakerPresenter? = null

    companion object {
        const val EMPTY_TEXT: String = ""
        const val DEFAULT_PRIORITY = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task_maker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = TaskMakerPresenterImpl(this)
        task_deadline.setOnClickListener(dateListener)
        task_deadline_time.setOnClickListener(timeListener)
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

    private val dateListener = View.OnClickListener {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(context, dateSetListener, year, month, day)
        dialog.show()
    }

    private val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
        task_deadline.text = getDateFormatted(day, month, year)
    }

    private fun getDateFormatted(day: Int, month: Int, year: Int): String {
        val monthInc = month + 1

        val dayString: String = if (day < 10) "0$day" else "$day"
        val monthString: String = if (monthInc < 10) "0$monthInc" else "$monthInc"
        val yearString = "$year"

        return getString(R.string.date_text, dayString, monthString, yearString)
    }

    private val timeListener = View.OnClickListener {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val dialog = TimePickerDialog(context, timeSetListener, hour, minute, true)
        dialog.show()
    }

    private val timeSetListener = TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
        task_deadline_time.text = getTimeFormatted(hourOfDay, minute)
    }

    private fun getTimeFormatted(hour: Int, minute: Int): String {
        val hourString: String = if (hour < 10) "0$hour" else "$hour"
        val minuteString: String = if (minute < 10) "0$minute" else "$minute"

        return getString(R.string.time_text, hourString, minuteString)
    }

    override fun getContext(): Context {
        return activity!!
    }

    override fun getTaskTitle(): String {
        return task_title.editText!!.text.toString()
    }

    override fun getTaskDescription(): String {
        return task_description.editText!!.text.toString()
    }

    override fun getTaskDeadline(): String {
        return task_deadline.text.toString()
    }

    override fun getTaskDeadlineTime(): String {
        return task_deadline_time.text.toString()
    }

    override fun getTaskPriority(): Int {
        return priority_bar.progress
    }

    override fun setTaskTitle(title: String?) {
        if (title == null)
            task_title.editText!!.setText(EMPTY_TEXT)
        else
            task_title.editText!!.setText(title)
    }

    override fun setTaskDescription(description: String?) {
        if (description == null)
            task_description.editText!!.setText(EMPTY_TEXT)
        else
            task_description.editText!!.setText(description)
    }

    override fun setTaskDeadline(deadline: String?) {
        if (deadline == null)
            task_deadline.text = EMPTY_TEXT
        else
            task_deadline.text = deadline
    }

    override fun setTaskDeadlineTime(time: String?) {
        if (time == null)
            task_deadline_time.text = EMPTY_TEXT
        else
            task_deadline_time.text = time
    }

    override fun setTaskPriority(priority: Int?) {
        if (priority == null)
            priority_bar.progress = DEFAULT_PRIORITY
        else
            priority_bar.progress = priority
    }

    override fun navigateToParentView() {
        activity?.finish()
    }
}
