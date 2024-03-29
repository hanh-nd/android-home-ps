package me.hanhngo.homeps.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.hanhngo.homeps.data.network.ApiService
import me.hanhngo.homeps.data.network.mapper.ApiMapper
import me.hanhngo.homeps.data.network.mapper.ApiMapperImpl
import me.hanhngo.homeps.repository.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://homeps.herokuapp.com/api/"

    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiMapper(): ApiMapper = ApiMapperImpl()

    @Provides
    @Singleton
    fun provideListBillRepository(
        apiService: ApiService,
        apiMapper: ApiMapper
    ): ListBillRepository =
        ListBillRepositoryImpl(apiService, apiMapper)

    @Provides
    @Singleton
    fun provideBillDetailRepository(
        apiService: ApiService,
        apiMapper: ApiMapper
    ): BillDetailRepository =
        BillDetailRepositoryImpl(apiService, apiMapper)


    @Provides
    @Singleton
    fun providePsRepository(
        apiService: ApiService,
        apiMapper: ApiMapper
    ): PlayStationRepository = PlayStationRepositoryImpl(apiService, apiMapper)
}