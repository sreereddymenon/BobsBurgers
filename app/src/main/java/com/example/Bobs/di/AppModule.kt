package com.example.Bobs.di

import com.example.Bobs.data.CharactersRepository
import com.example.Bobs.data.NetworkAPIService
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
    fun provideApiService() :NetworkAPIService {

        return Retrofit.Builder()
            .baseUrl("https://bobsburgers-api.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create()) // make this as a constant
            .build()
            .create(NetworkAPIService::class.java)

    }


    @Provides
    @Singleton
    fun providesCharactersRepository(apiService: NetworkAPIService): CharactersRepository {
        return CharactersRepository(apiService)
    }


}