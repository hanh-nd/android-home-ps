package me.hanhngo.homeps.domain


data class ListBill(
    val currentPlaying: Int,
    val currentPage: Int,
    val totalPage: Int,
    val currentTurns: List<Bill>
)