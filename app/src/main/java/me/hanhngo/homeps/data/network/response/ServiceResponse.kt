package me.hanhngo.homeps.data.network.response


import com.google.gson.annotations.SerializedName

data class ServiceResponse(
    val price: Int,
    val serviceId: Int,
    val serviceName: String
)