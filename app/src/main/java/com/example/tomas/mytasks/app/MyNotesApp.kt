package com.example.tomas.mytasks.app

import android.app.Application
import com.example.tomas.mytasks.di.AppComponent
import com.example.tomas.mytasks.di.DaggerAppComponent
import com.example.tomas.mytasks.di.DatabaseModule

class MyNotesApp : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder().databaseModule(DatabaseModule(this)).build()
    }
}