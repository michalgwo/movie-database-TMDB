package com.example.moviedatabase.presentation

import android.app.Application
import com.example.moviedatabase.BuildConfig
import com.example.moviedatabase.presentation.di.*

class App: Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.API_BASE_URL))
            .remoteDataSourceModule(RemoteDataSourceModule(BuildConfig.API_KEY))
            .build()
    }

    fun getAppComponent(): AppComponent = appComponent
}