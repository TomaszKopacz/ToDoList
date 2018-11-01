package com.example.tomas.mytasks.view

import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.tomas.mytasks.view.creator.TaskMakerActivity
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TaskCreatorActivityTest {

    @Rule
    var mTaskCreatorActivity: ActivityTestRule<TaskMakerActivity> = ActivityTestRule(
        TaskMakerActivity::class.java)
}