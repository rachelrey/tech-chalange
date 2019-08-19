package com.example.myassignment.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Content(
    @PrimaryKey
    val title: String,
    val rows: List<Info>
)

