package com.sunnyweather.android.logic.model

import com.google.gson.annotations.SerializedName

/**
 *  @author _BiN
 *  @function 定义数据模型的类和属性，按照城市数据接口返回的JSON格式来定义
 */
data class PlaceResponse(val status: String, val places: List<Place>)

data class Place(val name: String, val location: Location,
        @SerializedName("formatted_address") val address: String)

data class Location(val lng: String, val lat: String)