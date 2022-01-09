package me.hanhngo.homeps.data.network.mapper

import me.hanhngo.homeps.data.network.response.*
import me.hanhngo.homeps.domain.*

class ApiMapperImpl : ApiMapper {
    override fun mapBillResponseToDomain(response: BillResponse): Bill {
        return Bill(
            response.billId,
            response.playStation,
            response.orderServices.map { mapOrderServiceResponseToDomain(it) },
            mapEventResponseToDomain(response.event),
            response.timeStart,
            response.timeEnd,
            response.totalHourPlayed ?: 0.0,
            response.totalPrice,
            response.paid,
            if (response.paid) "Đã kết thúc" else "Đang chơi"
        )
    }

    override fun mapListBillResponseToDomain(response: ListBillResponse): ListBill {
        return ListBill(
            response.currentPlaying,
            response.currentPage,
            response.totalPage,
            response.currentTurns.map { mapBillResponseToDomain(it) }
        )
    }

    override fun mapOrderServiceResponseToDomain(response: OrderServiceResponse): OrderService {
        return OrderService(
            response.quantity,
            mapServiceResponseToDomain(response.service),
            response.totalPrice
        )
    }

    override fun mapServiceResponseToDomain(response: ServiceResponse): Service {
        return Service(
            response.price,
            response.serviceId,
            response.serviceName
        )
    }

    override fun mapEventResponseToDomain(response: EventResponse?): Event? {
        if (response == null) return null
        return Event(
            response.eventId,
            response.eventName,
            response.happenning,
            response.percentDiscount,
            response.timeEnd,
            response.timeStart
        )
    }
}