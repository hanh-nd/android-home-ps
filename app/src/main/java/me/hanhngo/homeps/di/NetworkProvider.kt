package me.hanhngo.homeps.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.hanhngo.homeps.view.home.BillProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkProvider {

    @Provides
    @Singleton
    fun provideBillProvider(): BillProvider = BillProvider()
}