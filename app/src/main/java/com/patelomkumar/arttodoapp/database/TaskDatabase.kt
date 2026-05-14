package com.patelomkumar.arttodoapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.patelomkumar.arttodoapp.model.Task

/**
 * The Room Database for the app.
 *
 * - [entities]  : all table classes
 * - [version]   : bump this number whenever you change the schema
 * - [exportSchema]: false keeps the project clean (set true in production for migrations)
 *
 * Uses the Singleton pattern so only one database instance exists at a time.
 */
@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {

    // Room generates the implementation of this function
    abstract fun taskDao(): TaskDao

    companion object {

        // @Volatile ensures all threads see the latest value immediately
        @Volatile
        private var INSTANCE: TaskDatabase? = null

        /**
         * Returns the singleton database instance, creating it if needed.
         * Thread-safe thanks to synchronized block.
         */
        fun getDatabase(context: Context): TaskDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "artist_todo_database"
                )
                .fallbackToDestructiveMigration() // Automatically wipe DB if schema changes
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
