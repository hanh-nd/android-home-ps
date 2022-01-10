package me.hanhngo.homeps.domain

import android.os.Parcelable
import androidx.databinding.BaseObservable
import kotlinx.parcelize.Parcelize
import me.hanhngo.homeps.data.network.response.OrderServiceResponse
import me.hanhngo.homeps.data.network.response.PlayStationResponse

@Parcelize
data class Bill(
    val id: Int,
    val ps: PlayStation,
    val services: List<OrderService>,
    val event: Event?,
    val startTime: String,
    val endTime: String?,
    val totalHourPlayed: Double,
    val price: Int?,
    val paid: Boolean,
    val status: String,
) : Parcelable