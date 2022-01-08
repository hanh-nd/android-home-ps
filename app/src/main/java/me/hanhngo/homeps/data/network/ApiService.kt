package me.hanhngo.homeps.data.network

import me.hanhngo.homeps.data.network.response.BillResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("bills")
    suspend fun getBillList(): Response<List<BillResponse>>
}