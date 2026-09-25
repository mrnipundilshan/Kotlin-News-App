package com.nipunapps.newsapp.core.di

import android.app.Application
import androidx.room3.Room
import com.nipunapps.newsapp.core.utils.Constants.BASE_URL
import com.nipunapps.newsapp.core.network.NewsApi
import com.nipunapps.newsapp.core.utils.Constants.NEWS_DATABASE_NAME
import com.nipunapps.newsapp.feature.bookmark.domain.usecases.DeleteArticle
import com.nipunapps.newsapp.feature.bookmark.domain.usecases.SelectArticles
import com.nipunapps.newsapp.feature.bookmark.domain.usecases.UpsertArticle
import com.nipunapps.newsapp.feature.homescreen.data.local.NewsDao
import com.nipunapps.newsapp.feature.homescreen.data.local.NewsDatabase
import com.nipunapps.newsapp.feature.homescreen.data.local.NewsTypeConverter
import com.nipunapps.newsapp.feature.homescreen.data.repository.NewsRepositoryImpl
import com.nipunapps.newsapp.feature.homescreen.domain.repository.NewsRepository
import com.nipunapps.newsapp.feature.homescreen.domain.usecases.GetNews
import com.nipunapps.newsapp.feature.homescreen.domain.usecases.NewsUseCases
import com.nipunapps.newsapp.feature.homescreen.domain.usecases.SearchNews
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
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManagerRepository(
        application: Application
    ): LocalUserManagerRepository = LocalUserManagerRepositoryImpl(application)


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
    fun providesNewsApi(): NewsApi {
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
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsDao),
            selectArticles = SelectArticles(newsDao),
            deleteArticle = DeleteArticle(newsDao)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ) : NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addColumnTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

}