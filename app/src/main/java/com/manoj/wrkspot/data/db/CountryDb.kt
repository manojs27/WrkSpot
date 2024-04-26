package com.manoj.wrkspot.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.manoj.wrkspot.data.model.Country

@Database(entities = [Country::class], version = 1, exportSchema = false)
abstract class CountryDb : RoomDatabase() {

    abstract fun countryDao(): CountryDao

    companion object {
        @Volatile
        private var INSTANCE: CountryDb? = null

        fun getDatabase(context: Context): CountryDb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CountryDb::class.java,
                    "app_database"
                ).addCallback(PopulateRoomCallback(context)).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
