package me.hanhngo.homeps.data.network.response


data class PlayStationResponse(
    val psId: Int,
    val psName: String,
    val psState: String,
    val psStatus: Int
)