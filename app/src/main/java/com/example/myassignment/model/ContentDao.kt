package com.example.myassignment.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContentDao {
    @get:Query("SELECT * FROM content")
    val content: Content

    fun insertContent(vararg content: Content)

}