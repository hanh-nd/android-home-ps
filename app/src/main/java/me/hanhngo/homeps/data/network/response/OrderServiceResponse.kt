package me.hanhngo.homeps.data.network.response


data class OrderServiceResponse(
    val quantity: Int,
    val service: ServiceResponse,
    val totalPrice: Int
)