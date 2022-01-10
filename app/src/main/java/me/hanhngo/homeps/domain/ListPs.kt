package me.hanhngo.homeps.domain

data class ListPs(
    val currentPage: Int,
    val totalPage: Int,
    val psList: List<PlayStation>
)