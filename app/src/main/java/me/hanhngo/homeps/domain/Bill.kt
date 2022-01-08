package me.hanhngo.homeps.domain


data class Bill(
    val billId: Int,
    val dailyEvent: Any?,
    val event: Any?,
    val orderServices: List<OrderService>,
    val paid: Boolean,
    val playStation: PlayStation,
    val timeEnd: String,
    val timeStart: String,
    val totalHourPlayed: Double,
    val totalPrice: Int
)