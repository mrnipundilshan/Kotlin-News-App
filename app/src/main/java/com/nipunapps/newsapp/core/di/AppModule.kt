package com.nipunapps.newsapp.core.di

import android.app.Application
import androidx.room3.Room
import com.nipunapps.newsapp.core.utils.Constants.BASE_URL
import com.nipunapps.newsapp.core.network.NewsApi
import com.nipunapps.newsapp.core.utils.Constants.NEWS_DATABASE_NAME
import com.nipunapps.newsapp.feature.bookmark.domain.usecases.DeleteArticle
import com.nipunapps.newsapp.feature.bookmark.domain.usecases.SelectArticles
import com.nipunapps.newsapp.feature.bookmark.domain.usecases.UpsertArticle
import com.nipunapps.newsapp.feature.detail.domain.usecases.SelectArticle
import com.nipunapps.newsapp.core.local.NewsDatabase
import com.nipunapps.newsapp.core.local.NewsTypeConverter
import com.nipunapps.newsapp.feature.bookmark.data.datasource.BookmarkDao
import com.nipunapps.newsapp.feature.bookmark.data.repository.BookmarkRepositoryImpl
import com.nipunapps.newsapp.feature.bookmark.domain.repository.BookmarkRepository
import com.nipunapps.newsapp.feature.bookmark.domain.usecases.BookmarkUseCases
import com.nipunapps.newsapp.feature.detail.data.datasource.DetailsDao
import com.nipunapps.newsapp.feature.detail.data.repository.DetailsRepositoryImpl
import com.nipunapps.newsapp.feature.detail.domain.repository.DetailsRepository
import com.nipunapps.newsapp.feature.detail.domain.usecases.DetailsUseCases
import com.nipunapps.newsapp.feature.homescreen.data.repository.NewsRepositoryImpl
import com.nipunapps.newsapp.feature.homescreen.domain.repository.NewsRepository
import com.nipunapps.newsapp.feature.homescreen.domain.usecases.GetNews
import com.nipunapps.newsapp.feature.homescreen.domain.usecases.NewsUseCases
import com.nipunapps.newsapp.feature.search.domain.usecases.SearchNews
import com.nipunapps.newsapp.feature.onboarding.data.repository.LocalUserManagerRepositoryImpl
import com.nipunapps.newsapp.feature.onboarding.domain.repository.LocalUserManagerRepository
import com.nipunapps.newsapp.feature.onboarding.domain.usecases.AppEntryUseCases
import com.nipunapps.newsapp.feature.onboarding.domain.usecases.ReadAppEntry
import com.nipunapps.newsapp.feature.onboarding.domain.usecases.SaveAppEntry
import com.nipunapps.newsapp.feature.search.domain.repository.SearchRepository
import com.nipunapps.newsapp.feature.search.domain.usecases.SearchUseCases
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
        newsApi: NewsApi,
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideBookmarkRepository(
        bookmarkDao: BookmarkDao,
    ): BookmarkRepository = BookmarkRepositoryImpl(bookmarkDao)

    @Provides
    @Singleton
    fun provideDetailsRepository(
        detailsDao: DetailsDao,
    ): DetailsRepository = DetailsRepositoryImpl(detailsDao)




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
    fun provideBookmarkDao(
        database: NewsDatabase
    ): BookmarkDao = database.bookmarkDao

    @Provides
    @Singleton
    fun provideDetailsDao(
        database: NewsDatabase
    ): DetailsDao = database.detailsDao



    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
        )
    }

    @Provides
    @Singleton
    fun provideDetailsUseCases(
        detailsRepository: DetailsRepository
    ) : DetailsUseCases {
        return DetailsUseCases(
            selectArticle = SelectArticle(detailsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideBookmarkUseCases(
        bookmarkRepository: BookmarkRepository
    ) : BookmarkUseCases{
        return BookmarkUseCases(
            deleteArticle = DeleteArticle(bookmarkRepository),
            selectArticles = SelectArticles(bookmarkRepository),
            upsertArticle = UpsertArticle(bookmarkRepository)
        )
    }

    @Provides
    @Singleton
    fun provideSearchNewsUseCases(
        searchRepository: SearchRepository
    ) : SearchUseCases {
        return SearchUseCases(
            searchNews = SearchNews(searchRepository)
        )


    }
}