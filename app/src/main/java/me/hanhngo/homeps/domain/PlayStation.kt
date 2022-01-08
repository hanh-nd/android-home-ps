package me.hanhngo.homeps.domain


import com.google.gson.annotations.SerializedName

data class PlayStation(
    val psId: Int,
    val psName: String,
    val psState: String,
    val psStatus: Int
)