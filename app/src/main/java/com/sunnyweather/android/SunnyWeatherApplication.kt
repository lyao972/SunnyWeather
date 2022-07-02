package com.sunnyweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 *  @author _BiN
 *  @function 提供一种全局获取Context的方式
 */
class SunnyWeatherApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        const val TOKEN = "n7sCSPs9q45Spxyj"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}