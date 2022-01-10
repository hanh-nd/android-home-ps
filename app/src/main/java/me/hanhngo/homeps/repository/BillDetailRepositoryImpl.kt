package me.hanhngo.homeps.repository

import kotlinx.coroutines.flow.flow
import me.hanhngo.homeps.data.network.ApiService
import me.hanhngo.homeps.data.network.mapper.ApiMapper
import me.hanhngo.homeps.util.Resource
import javax.inject.Inject


class BillDetailRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val apiMapper: ApiMapper
) : BillDetailRepository {
    override fun checkout(id: Int) = flow {
        emit(Resource.Loading)
        try {
            val response = apiService.checkout(id)
            val result = response.body()

            if (response.isSuccessful && result != null) {
                emit(Resource.Success(apiMapper.mapBillResponseToDomain(result)))
            } else {
                emit(Resource.Error(response.errorBody()!!.toString()))
            }
        } catch (e: Exception) {
            emit(Resource.Error("An error occurred."))
        }


    }

    override fun fetchBillDetail(id: Int) = flow {
        emit(Resource.Loading)
        try {
            val response = apiService.getBillDetail(id)
            val result = response.body()

            if (response.isSuccessful && result != null) {
                emit(Resource.Success(apiMapper.mapBillResponseToDomain(result)))
            } else {
                emit(Resource.Error(response.errorBody()!!.toString()))
            }
        } catch (e: Exception) {
            emit(Resource.Error("An error occurred."))
        }

    }
}