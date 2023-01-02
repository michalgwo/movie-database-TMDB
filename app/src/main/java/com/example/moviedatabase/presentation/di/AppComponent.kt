package com.example.moviedatabase.presentation.di

import com.example.moviedatabase.presentation.HomeActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    DatabaseModule::class,
    RemoteDataSourceModule::class,
    LocalDataSourceModule::class,
    CacheDataSourceModule::class,
    RepoModule::class,
    UseCaseModule::class
])
interface AppComponent {
    fun inject(homeActivity: HomeActivity)
}