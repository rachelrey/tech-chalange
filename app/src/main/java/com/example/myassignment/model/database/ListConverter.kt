package com.example.myassignment.model.database

import androidx.room.TypeConverter
import com.example.myassignment.model.Info
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class ListConverter {

    var gson = Gson()
    @TypeConverter
    fun fromString(value: String?): List<Info> {
        if (value == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<Info>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromInfoListToString(infos: List<Info>): String? {
        return gson.toJson(infos)
    }
}






