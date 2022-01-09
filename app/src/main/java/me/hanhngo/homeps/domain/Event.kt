package me.hanhngo.homeps.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    val id: Int,
    val name: String,
    val happening: Boolean,
    val percentDiscount: Int,
    val timeEnd: String,
    val timeStart: String
) : Parcelable