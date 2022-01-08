package me.hanhngo.homeps.mapper.domain

import me.hanhngo.homeps.domain.Bill
import me.hanhngo.homeps.view.home.model.BillItem

interface DomainMapper {

    fun fromDomainToBillItem(bill: Bill, onClick:(Bill) -> Unit): BillItem
}