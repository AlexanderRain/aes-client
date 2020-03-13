package com.essay.grader.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "essay_table")
class Essay(@PrimaryKey
            @ColumnInfo(name = "id") val id: Int,
            @ColumnInfo(name = "topic") val topic: String,
            @ColumnInfo(name = "essay") val essay: String,
            @ColumnInfo(name = "rate") val rate: Int)