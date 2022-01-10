package me.hanhngo.homeps.data.network.response

data class ListPsResponse(
    val currentPage: Int,
    val totalPage: Int,
    val psList: List<PlayStationResponse>
)