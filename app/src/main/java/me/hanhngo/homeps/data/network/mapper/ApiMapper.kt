package me.hanhngo.homeps.data.network.mapper

import me.hanhngo.homeps.data.network.response.*
import me.hanhngo.homeps.domain.*

interface ApiMapper {

    fun mapBillResponseToDomain(response: BillResponse): Bill
    fun mapListBillResponseToDomain(response: ListBillResponse): ListBill
    fun mapOrderServiceResponseToDomain(response: OrderServiceResponse): OrderService
    fun mapServiceResponseToDomain(response: ServiceResponse): Service
    fun mapEventResponseToDomain(response: EventResponse?): Event?
    fun mapPsResponseToDomain(response: PlayStationResponse): PlayStation
    fun mapListPsResponseToDomain(response: ListPsResponse): ListPs
}