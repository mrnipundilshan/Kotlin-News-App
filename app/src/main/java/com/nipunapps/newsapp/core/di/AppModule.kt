package com.nipunapps.newsapp.core.di

import android.app.Application
import com.nipunapps.newsapp.feature.onboarding.data.repository.LocalUserManagerRepositoryImpl
import com.nipunapps.newsapp.feature.onboarding.domain.repository.LocalUserManagerRepository
import com.nipunapps.newsapp.feature.onboarding.domain.usecases.AppEntryUseCases
import com.nipunapps.newsapp.feature.onboarding.domain.usecases.ReadAppEntry
import com.nipunapps.newsapp.feature.onboarding.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManagerRepository(
        application: Application
    ) : LocalUserManagerRepository = LocalUserManagerRepositoryImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManagerRepository: LocalUserManagerRepository
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManagerRepository),
        saveAppEntry = SaveAppEntry(localUserManagerRepository)
    )
}