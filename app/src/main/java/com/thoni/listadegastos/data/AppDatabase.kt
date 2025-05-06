package com.thoni.listadegastos.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thoni.listadegastos.model.Gasto

@Database(entities = [Gasto::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun gastoDao(): GastoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "gasto_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}