package com.example.myassignment.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myassignment.model.Content
import com.example.myassignment.model.ContentDao

@Database(entities = [Content::class], version = 1, exportSchema = false)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contentDao(): ContentDao
}