package com.manoj.wrkspot.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.manoj.wrkspot.data.model.Country
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {
    @Insert
    suspend fun insertCountry(country: Country)

    @Query("SELECT * FROM country")
    fun getAllCountries(): Flow<List<Country>>
}