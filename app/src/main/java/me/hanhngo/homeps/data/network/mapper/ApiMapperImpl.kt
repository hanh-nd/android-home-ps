package me.hanhngo.homeps.data.network.mapper

import me.hanhngo.homeps.data.network.response.BillResponse
import me.hanhngo.homeps.view.home.model.BillItem

class ApiMapperImpl : ApiMapper {
    override fun mapBillResponseToDomain(response: BillResponse): BillItem {
        return BillItem(
            response.billId,
            response.playStation,
            response.timeStart,
            if (response.paid) "Đã kết thúc" else "Đang chơi"
        )
    }
}