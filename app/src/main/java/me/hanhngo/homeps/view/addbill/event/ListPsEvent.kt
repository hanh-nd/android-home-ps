package me.hanhngo.homeps.view.addbill.event

import me.hanhngo.homeps.domain.PlayStation

sealed class ListPsEvent {
    data class CreateNewTurn(val ps: PlayStation) : ListPsEvent()
}