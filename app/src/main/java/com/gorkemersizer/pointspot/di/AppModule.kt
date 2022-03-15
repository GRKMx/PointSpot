package com.gorkemersizer.pointspot.di

import android.app.Application
import androidx.room.Room
import com.gorkemersizer.pointspot.data.SpotDatabase
import com.gorkemersizer.pointspot.data.SpotRepositoryImpl
import com.gorkemersizer.pointspot.domain.repository.SpotRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideSpotDatabase(app: Application): SpotDatabase {
        return Room.databaseBuilder(
            app,
            SpotDatabase::class.java,
            "spots.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideSpotRepository(db: SpotDatabase): SpotRepository {
        return SpotRepositoryImpl(db.dao)
    }
}