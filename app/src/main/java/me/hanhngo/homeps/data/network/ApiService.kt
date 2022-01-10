package me.hanhngo.homeps.data.network

import me.hanhngo.homeps.data.network.response.BillResponse
import me.hanhngo.homeps.data.network.response.ListBillResponse
import me.hanhngo.homeps.data.network.response.ListPsResponse
import me.hanhngo.homeps.view.addbill.model.request.PsRequest
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("bills")
    suspend fun getBillList(@Query("size") size: Int): Response<ListBillResponse>

    @GET("bills/{id}")
    suspend fun getBillDetail(@Path("id") id: Int): Response<BillResponse>

    @PUT("bills/endbill/{id}")
    suspend fun checkout(@Path("id") id: Int): Response<BillResponse>

    @GET("ps?status=free")
    suspend fun getPsList(@Query("size") size: Int): Response<ListPsResponse>

    @POST("bills")
    suspend fun createNewTurn(@Body psRequest: PsRequest): Response<BillResponse>
}