package me.hanhngo.homeps.view.home.event

import me.hanhngo.homeps.domain.Bill

sealed class ListBillEvent {
    data class ShowBillDetail(val bill: Bill) : ListBillEvent()
}
