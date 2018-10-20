package com.example.tomas.mytasks.view

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.*
import org.junit.runner.RunWith
import android.support.test.rule.ActivityTestRule
import com.example.tomas.mytasks.R
import kotlinx.android.synthetic.main.activity_task_creator.view.*
import org.junit.Rule
import org.junit.Test

@RunWith(AndroidJUnit4::class)
@LargeTest
class TaskCreatorActivityTest {

    companion object {
        const val TITLE = "TITLE"
        const val DESCRIPTION = "DESCRIPTION"
        const val DEADLINE = "DEADLINE"
        const val PRIORITY = 4
    }

    @Rule
    var mTaskCreatorActivity: ActivityTestRule<TaskCreatorActivity> = ActivityTestRule(TaskCreatorActivity::class.java)

//    @Test
//    fun getTextFromFieldsWhenTyped(){
//        Espresso.onView(ViewMatchers.withId(R.id.title))
//            .perform(ViewActions.typeText(TITLE))
//        Espresso.onView(ViewMatchers.withId(R.id.description))
//            .perform(ViewActions.typeText(DESCRIPTION))
//        Espresso.onView(ViewMatchers.withId(R.id.deadline))
//            .perform(ViewActions.typeText(DEADLINE))
//    }
}