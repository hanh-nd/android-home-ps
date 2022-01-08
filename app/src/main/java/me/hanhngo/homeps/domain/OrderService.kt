package me.hanhngo.homeps.domain


data class OrderService(
    val quantity: Int,
    val service: Service,
    val totalPrice: Int
)