package me.hanhngo.homeps.data.network.response


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlayStationResponse(
    val psId: Int,
    val psName: String,
    val psState: String,
    val psStatus: Int
) : Parcelable