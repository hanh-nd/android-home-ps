package me.hanhngo.homeps.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Service(
    val price: Int,
    val serviceId: Int,
    val serviceName: String
) : Parcelable