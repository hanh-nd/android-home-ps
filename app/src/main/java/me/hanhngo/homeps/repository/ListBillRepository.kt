package me.hanhngo.homeps.repository

import kotlinx.coroutines.flow.Flow
import me.hanhngo.homeps.data.network.response.BillResponse
import me.hanhngo.homeps.domain.Bill
import me.hanhngo.homeps.util.Resource
import me.hanhngo.homeps.view.home.model.BillItem

interface ListBillRepository {
    fun fetchBillFromNetwork(): Flow<Resource<List<Bill>>>
}