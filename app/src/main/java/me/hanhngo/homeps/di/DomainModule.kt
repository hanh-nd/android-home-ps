package me.hanhngo.homeps.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.hanhngo.homeps.mapper.domain.DomainMapper
import me.hanhngo.homeps.mapper.domain.DomainMapperImpl
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideDomainMapper(): DomainMapper = DomainMapperImpl()
}