package com.example.tomas.mytasks.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Task {

    companion object {
        const val TITLE = "title"
        const val DESCRIPTION = "description"
        const val TERMINATION = "must_to_do_date"
        const val TERMINATION_TIME = "must_to_do_time"
        const val PRIORITY = "priority"
    }

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

    @ColumnInfo(name = TITLE)
    var title : String = ""

    @ColumnInfo(name = DESCRIPTION)
    var description : String = ""

    @ColumnInfo(name = TERMINATION)
    var deadline : String = ""

    @ColumnInfo(name = TERMINATION_TIME)
    var time : String = ""

    @ColumnInfo(name = PRIORITY)
    var priority : Int = 1
}