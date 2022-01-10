package me.hanhngo.homeps.repository

import kotlinx.coroutines.flow.Flow
import me.hanhngo.homeps.domain.Bill
import me.hanhngo.homeps.domain.ListPs
import me.hanhngo.homeps.util.Resource
import me.hanhngo.homeps.view.addbill.model.request.PsRequest

interface PlayStationRepository {
    fun fetchPsFromNetwork(size: Int): Flow<Resource<ListPs>>
    fun createNewBill(psRequest: PsRequest): Flow<Resource<Bill>>
}