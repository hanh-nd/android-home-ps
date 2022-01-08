package me.hanhngo.homeps.view.home.model

import me.hanhngo.homeps.R
import me.hanhngo.homeps.data.network.response.PlayStationResponse
import me.hanhngo.homeps.domain.Bill
import me.hanhngo.homeps.view.home.HomeViewModel

data class BillItem(
    val bill: Bill,
    private val onItemClick:(Bill) -> Unit
) :
    ItemViewModel {
    override val layoutId: Int
        get() = R.layout.list_bill_item
    override val viewType: Int
        get() = HomeViewModel.BILL_ITEM

    fun onClick() {
        onItemClick(bill)
    }
}