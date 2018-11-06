package com.example.tomas.mytasks.di

import com.example.tomas.mytasks.board.BoardActivity
import com.example.tomas.mytasks.creator.TaskMakerActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class])
interface AppComponent {

    fun inject(activity: BoardActivity)
    fun inject(activity: TaskMakerActivity)
}