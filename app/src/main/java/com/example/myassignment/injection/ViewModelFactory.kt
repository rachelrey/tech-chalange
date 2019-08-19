package com.example.myassignment.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.myassignment.model.database.AppDatabase
import com.example.myassignment.presentation.InfoListViewModel

class ViewModelFactory(private val activity: AppCompatActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InfoListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "content").build()
            @Suppress("UNCHECKED_CAST")
            return InfoListViewModel(db.contentDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}




