package com.example.tomas.mytasks.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Task {

    companion object {
        private const val TITLE = "title"
        private const val CREATION = "creation_date"
        private const val DESCRIPTION = "description"
        private const val TERMINATION = "must_to_do_date"
        private const val PRIORITY = "priority"
    }

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

    @ColumnInfo(name = TITLE)
    var title : String = ""

    @ColumnInfo(name = CREATION)
    var creationDate : String = ""

    @ColumnInfo(name = DESCRIPTION)
    var description : String = ""

    @ColumnInfo(name = TERMINATION)
    var deadline : String = ""

    @ColumnInfo(name = PRIORITY)
    var priority : Int = 1
}