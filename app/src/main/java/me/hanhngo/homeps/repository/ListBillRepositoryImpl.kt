package me.hanhngo.homeps.repository

import kotlinx.coroutines.flow.flow
import me.hanhngo.homeps.data.network.ApiService
import me.hanhngo.homeps.data.network.mapper.ApiMapper
import me.hanhngo.homeps.util.Resource
import javax.inject.Inject

class ListBillRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val apiMapper: ApiMapper
) : ListBillRepository {
    override fun fetchBillFromNetwork() = flow {
        emit(Resource.Loading)

        try {
            val response = apiService.getBillList(50)
            val result = response.body()

            if (response.isSuccessful && result != null) {
                emit(Resource.Success(apiMapper.mapListBillResponseToDomain(result)))
            } else {
                emit(Resource.Error(response.errorBody()!!.toString()))
            }
        } catch (e: Exception) {
            emit(Resource.Error("An error occurred."))
        }
    }
}