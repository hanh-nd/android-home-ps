package me.hanhngo.homeps.data.network.mapper

import me.hanhngo.homeps.data.network.response.BillResponse
import me.hanhngo.homeps.view.home.model.BillItem

interface ApiMapper {

    fun mapBillResponseToDomain(response: BillResponse): BillItem
}