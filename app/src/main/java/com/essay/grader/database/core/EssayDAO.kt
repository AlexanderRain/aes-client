package com.essay.grader.database.core

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.essay.grader.database.entity.Essay

@Dao
interface EssayDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(essay: Essay)

    @Query("SELECT * FROM essay_table")
    suspend fun getAll(): LiveData<List<Essay>>

    @Query("SELECT * FROM essay_table WHERE id=id")
    suspend fun getSingle(id: Int): LiveData<Essay>

    @Query("DELETE FROM essay_table WHERE id=id")
    suspend fun deleteSingle(id: Int)

    @Query("DELETE FROM essay_table")
    suspend fun deleteAll()
}