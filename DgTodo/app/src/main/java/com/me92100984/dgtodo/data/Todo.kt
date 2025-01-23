package com.me92100984.dgtodo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_todo")
data class Todo (
    @PrimaryKey(autoGenerate = true)
    val num: Int = 0,
    val title: String,
    val completed: Boolean = false
)
