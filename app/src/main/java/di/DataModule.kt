package di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import data.PortfolioItemRepositoryImpl
import data.PortfolioRepositoryImpl
import data.datasource.interfaces.PortfolioDataSource
import data.datasource.interfaces.PortfolioItemDataSource
import data.datasource.local.LocalPortfolioDataSource
import data.datasource.local.LocalPortfolioItemDataSource
import domain.repository.PortfolioRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    @Singleton
    fun bindPortfolioRepository(
        repositoryImpl: PortfolioRepositoryImpl
    ): PortfolioRepository

    @Binds
    @Singleton
    fun bindPortfolioItemRepository(
        repositoryImpl: PortfolioItemRepositoryImpl
    ): PortfolioItemRepositoryImpl

    @Binds
    @Singleton
    fun bindPortfolioDataSource(
        dataSourceImpl: LocalPortfolioDataSource
    ): PortfolioDataSource

    @Binds
    @Singleton
    fun bindPortfolioItemDataSource(
        dataSourceImpl: LocalPortfolioItemDataSource
    ): PortfolioItemDataSource
}
