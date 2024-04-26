package com.manoj.wrkspot.domain.repository

import com.manoj.wrkspot.data.model.Country
import com.manoj.wrkspot.data.db.CountryDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CountryRepository @Inject constructor(private val countryDao: CountryDao) {

    fun getAllCountries(): Flow<List<Country>> = countryDao.getAllCountries()
}