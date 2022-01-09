package me.hanhngo.homeps.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrderService(
    val quantity: Int,
    val service: Service,
    val totalPrice: Int
) : Parcelable