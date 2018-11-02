package com.example.tomas.mytasks.di

import com.example.tomas.mytasks.presenter.board.BoardPresenterImpl
import com.example.tomas.mytasks.presenter.creator.TaskMakerPresenterImpl
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class])
interface AppComponent {

    fun inject(presenter: BoardPresenterImpl)
    fun inject(presenter: TaskMakerPresenterImpl)
}