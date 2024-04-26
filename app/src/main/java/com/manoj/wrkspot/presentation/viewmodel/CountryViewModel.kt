package com.manoj.wrkspot.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.manoj.wrkspot.domain.repository.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val countryRepository: CountryRepository
) : ViewModel() {
    val countryList get() = countryRepository.getAllCountries()
}