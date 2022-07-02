package com.sunnyweather.android.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 *  @author _BiN
 *  @function 定义一个统一的网络数据源访问入口，对所有网络请求进行封装
 */

object SunnyWeatherNetwork {

    private val placeService = ServiceCreator.create<PlaceService>()

    //App 在发起网络请求拉取数据的同时，需要能保证用户在界面上的操作也能正常响应，界面可以刷新。
    // 所以，就需要一套机制能保证耗时的 IO 操作，能与 UI 刷新操作同步执行。
    suspend fun <T> searchPlaces(query: String) = placeService.searchPlaces(query).await()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine {  continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if(body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}








