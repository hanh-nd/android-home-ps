package me.hanhngo.homeps.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.hanhngo.homeps.domain.mapper.DomainMapper
import me.hanhngo.homeps.domain.mapper.DomainMapperImpl
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideDomainMapper(): DomainMapper = DomainMapperImpl()
}