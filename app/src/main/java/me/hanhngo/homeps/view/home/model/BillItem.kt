package me.hanhngo.homeps.view.home.model

import me.hanhngo.homeps.R
import me.hanhngo.homeps.data.network.response.PlayStationResponse
import me.hanhngo.homeps.view.home.HomeViewModel

data class BillItem(val id: Int, val ps: PlayStationResponse, val startTime: String, val status: String) :
    ItemViewModel {
    override val layoutId: Int
        get() = R.layout.list_bill_item
    override val viewType: Int
        get() = HomeViewModel.BILL_ITEM
}