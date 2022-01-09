package me.hanhngo.homeps.data.network

import me.hanhngo.homeps.data.network.response.BillResponse
import me.hanhngo.homeps.data.network.response.ListBillResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("bills")
    suspend fun getBillList(@Query("size") size: Int): Response<ListBillResponse>
}