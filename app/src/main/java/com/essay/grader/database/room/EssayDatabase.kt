package com.essay.grader.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.essay.grader.database.core.EssayDAO
import com.essay.grader.database.entity.Essay

@Database(entities = [Essay::class], version = 1, exportSchema = false)
abstract class EssayDatabase : RoomDatabase() {

    abstract fun wordDao(): EssayDAO

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: EssayDatabase? = null

        fun getDatabase(context: Context): EssayDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        EssayDatabase::class.java,
                        "essay_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}