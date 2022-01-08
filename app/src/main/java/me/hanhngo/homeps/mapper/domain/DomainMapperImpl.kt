package me.hanhngo.homeps.mapper.domain

import me.hanhngo.homeps.domain.Bill
import me.hanhngo.homeps.view.home.model.BillItem

class DomainMapperImpl : DomainMapper {
    override fun fromDomainToBillItem(bill: Bill, onClick: (Bill) -> Unit): BillItem {
        return BillItem(
            bill,
            onClick
        )
    }
}