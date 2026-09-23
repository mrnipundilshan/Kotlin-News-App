package com.nipunapps.newsapp.core.di

import android.app.Application
import com.nipunapps.newsapp.core.utils.Constants.BASE_URL
import com.nipunapps.newsapp.feature.homescreen.data.datasource.NewsApi
import com.nipunapps.newsapp.feature.homescreen.data.repository.NewsRepositoryImpl
import com.nipunapps.newsapp.feature.homescreen.domain.repository.NewsRepository
import com.nipunapps.newsapp.feature.homescreen.domain.usecases.GetNews
import com.nipunapps.newsapp.feature.homescreen.domain.usecases.NewsUseCases
import com.nipunapps.newsapp.feature.onboarding.data.repository.LocalUserManagerRepositoryImpl
import com.nipunapps.newsapp.feature.onboarding.domain.repository.LocalUserManagerRepository
import com.nipunapps.newsapp.feature.onboarding.domain.usecases.AppEntryUseCases
import com.nipunapps.newsapp.feature.onboarding.domain.usecases.ReadAppEntry
import com.nipunapps.newsapp.feature.onboarding.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.annotation.Signed
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

    @Provides
    @Singleton
    fun providesNewsApi(): NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(newsRepository: NewsRepository): NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }
}