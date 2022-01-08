package me.hanhngo.homeps.data.network.mapper

import me.hanhngo.homeps.data.network.response.BillResponse
import me.hanhngo.homeps.domain.Bill
import me.hanhngo.homeps.view.home.model.BillItem

class ApiMapperImpl : ApiMapper {
    override fun mapBillResponseToDomain(response: BillResponse): Bill {
        return Bill(
            response.billId,
            response.playStation,
            response.timeStart,
            response.timeEnd,
            response.totalPrice,
            response.paid,
            if (response.paid) "Đã kết thúc" else "Đang chơi"
        )
    }
}