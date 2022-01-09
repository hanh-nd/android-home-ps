package me.hanhngo.homeps.data.network.response


data class BillResponse(
    val billId: Int,
    val dailyEvent: Any?,
    val event: EventResponse?,
    val orderServices: List<OrderServiceResponse>,
    val paid: Boolean,
    val playStation: PlayStationResponse,
    val timeEnd: String?,
    val timeStart: String,
    val totalHourPlayed: Double?,
    val totalPrice: Int?
)