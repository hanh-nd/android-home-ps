package me.hanhngo.homeps.domain


import com.google.gson.annotations.SerializedName

data class Service(
    val price: Int,
    val serviceId: Int,
    val serviceName: String
)