package me.hanhngo.homeps.view.billdetail.model

import me.hanhngo.homeps.data.network.response.ServiceResponse

data class OrderService(
    val quantity: Int,
    val service: ServiceResponse,
    val totalPrice: Int
)