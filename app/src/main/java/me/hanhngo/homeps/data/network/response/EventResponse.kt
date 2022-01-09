package me.hanhngo.homeps.data.network.response



data class EventResponse(
    val eventId: Int,
    val eventName: String,
    val happenning: Boolean,
    val percentDiscount: Int,
    val timeEnd: String,
    val timeStart: String
)