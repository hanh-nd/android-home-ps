package me.hanhngo.homeps.repository

import kotlinx.coroutines.flow.Flow
import me.hanhngo.homeps.domain.Bill
import me.hanhngo.homeps.util.Resource

interface BillDetailRepository {
    fun checkout(id: Int): Flow<Resource<Bill>>
    fun fetchBillDetail(id: Int): Flow<Resource<Bill>>
}