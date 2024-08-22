package data.datasource.local

import data.datasource.examples.ExamplePortfolioList
import data.datasource.interfaces.PortfolioDataSource
import domain.entity.Portfolio
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class LocalPortfolioDataSource @Inject constructor() : PortfolioDataSource {
    override suspend fun getPortfolios(): Flow<List<Portfolio>> {
        return withContext(Dispatchers.IO) {
            flow {
                emit(ExamplePortfolioList.getPortfolioList())
            }
        }
    }

    override suspend fun getPortfolioById(id: Int): Flow<Portfolio> {
        return withContext(Dispatchers.IO) {
            flow {
                emit(ExamplePortfolioList.getPortfolioById(id))
            }
        }
    }

    override suspend fun createPortfolio(name: String) {
        return withContext(Dispatchers.IO) {
            ExamplePortfolioList.createPortfolio(name)
        }
    }

    override suspend fun updatePortfolio(id: Int, portfolio: Portfolio) {
        return withContext(Dispatchers.IO) {
            ExamplePortfolioList.updatePortfolio(id, portfolio)
        }
    }

    override suspend fun deletePortfolio(id: Int) {
        return withContext(Dispatchers.IO) {
            ExamplePortfolioList.deletePortfolio(id)
        }
    }
}
