package me.hanhngo.homeps.data.network.response


data class ListBillResponse(
    val currentPlaying: Int,
    val currentPage: Int,
    val totalPage: Int,
    val currentTurns: List<BillResponse>
)