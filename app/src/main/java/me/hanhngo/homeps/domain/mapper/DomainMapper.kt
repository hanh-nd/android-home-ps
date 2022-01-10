package me.hanhngo.homeps.domain.mapper

import me.hanhngo.homeps.domain.Bill
import me.hanhngo.homeps.domain.PlayStation
import me.hanhngo.homeps.view.addbill.model.PsItem
import me.hanhngo.homeps.view.home.model.BillItem

interface DomainMapper {

    fun fromDomainToBillItem(bill: Bill, onClick:(Bill) -> Unit): BillItem
    fun fromDomainToPsItem(playStation: PlayStation, onClick: (PlayStation) -> Unit): PsItem
}