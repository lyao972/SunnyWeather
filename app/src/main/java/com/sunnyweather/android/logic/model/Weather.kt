package com.sunnyweather.android.logic.model

/**
 *  @author _BiN
 *  @function
 */
data class Weather(val realtime: RealtimeResponse.Realtime, val daily: DailyResponse.Daily)