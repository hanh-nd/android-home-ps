package me.hanhngo.homeps.data.network.response


import com.google.gson.annotations.SerializedName

data class PlayStationResponse(
    val psId: Int,
    val psName: String,
    val psState: String,
    val psStatus: Int
)