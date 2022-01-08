package me.hanhngo.homeps.view.home.model

import me.hanhngo.homeps.R
import me.hanhngo.homeps.view.home.HomeViewModel

data class BillHeader(val time: String) : ItemViewModel {
    override val layoutId: Int
        get() = R.layout.list_bill_header
    override val viewType: Int
        get() = HomeViewModel.BILL_HEADER
}
