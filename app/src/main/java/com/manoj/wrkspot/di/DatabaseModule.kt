package com.manoj.wrkspot.di

import android.content.Context
import com.manoj.wrkspot.data.db.CountryDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideUserDatabase(@ApplicationContext context: Context): CountryDb =
        CountryDb.getDatabase(context)

    @Provides
    fun provideUserDao(countryDb: CountryDb) = countryDb.countryDao()
}