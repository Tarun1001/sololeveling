package com.teach.sololeveling.core.di

import com.teach.sololeveling.core.utils.AppConstants.BASE_URL
import com.teach.sololeveling.sports.data.remote.SportApi
import com.teach.sololeveling.sports.data.repo.SportsRepoImpl
import com.teach.sololeveling.sports.domain.repo.SportsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SportsModule {

    @Provides
    fun providesRetrofitApi(retrofit: Retrofit): SportApi {
        return retrofit.create(SportApi::class.java)
    }


    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {

        return Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl(BASE_URL)
            .build()
    }


    @Provides
    @Singleton
    fun providesSportsRepo( api: SportApi): SportsRepo {
        return SportsRepoImpl( api)
    }

}