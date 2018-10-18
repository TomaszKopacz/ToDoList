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
    var id : Int? = null

    @ColumnInfo(name = TITLE)
    var title : String? = null

    @ColumnInfo(name = CREATION)
    var creationDate : String? = null

    @ColumnInfo(name = DESCRIPTION)
    var description : String? = null

    @ColumnInfo(name = TERMINATION)
    var mustToDoDate : String? = null

    @ColumnInfo(name = PRIORITY)
    var priority : Int? = null
}