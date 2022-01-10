package me.hanhngo.homeps.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlayStation(
    val id: Int,
    val name: String,
    val state: String,
    val status: Int
) : Parcelable