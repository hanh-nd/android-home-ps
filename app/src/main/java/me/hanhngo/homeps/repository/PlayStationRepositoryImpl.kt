package me.hanhngo.homeps.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.hanhngo.homeps.data.network.ApiService
import me.hanhngo.homeps.data.network.mapper.ApiMapper
import me.hanhngo.homeps.domain.Bill
import me.hanhngo.homeps.domain.ListPs
import me.hanhngo.homeps.util.Resource
import me.hanhngo.homeps.view.addbill.model.request.PsRequest
import javax.inject.Inject

class PlayStationRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val apiMapper: ApiMapper
) : PlayStationRepository {
    override fun fetchPsFromNetwork(size: Int): Flow<Resource<ListPs>> = flow {
        emit(Resource.Loading)
        try {
            val response = apiService.getPsList(50)
            val result = response.body()

            if (response.isSuccessful && result != null) {
                emit(Resource.Success(apiMapper.mapListPsResponseToDomain(result)))
            } else {
                emit(Resource.Error(response.errorBody()!!.toString()))
            }
        } catch (e: Exception) {
            emit(Resource.Error("An error occurred."))
        }

    }

    override fun createNewBill(psRequest: PsRequest): Flow<Resource<Bill>> = flow {
        emit(Resource.Loading)
        try {
            val response = apiService.createNewTurn(psRequest)
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