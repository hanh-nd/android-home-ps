package me.hanhngo.homeps.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import me.hanhngo.homeps.data.network.response.PlayStationResponse

@Parcelize
data class Bill(
    val id: Int,
    val ps: PlayStationResponse,
    val startTime: String,
    val endTime: String?,
    val price: Int?,
    val paid: Boolean,
    val status: String,
) : Parcelable