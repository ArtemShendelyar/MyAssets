package data.datasource.local

import data.datasource.examples.ExamplePortfolioList
import data.datasource.interfaces.PortfolioDataSource
import domain.entity.Portfolio
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalPortfolioDataSource @Inject constructor() : PortfolioDataSource {
    override suspend fun getPortfolios(): List<Portfolio> {
        return withContext(Dispatchers.IO) {
            ExamplePortfolioList.getPortfolioList()
        }
    }

    override suspend fun getPortfolioById(id: Int): Portfolio? {
        TODO("Not yet implemented")
    }

    override suspend fun createPortfolio(portfolio: Portfolio) {
        TODO("Not yet implemented")
    }

    override suspend fun updatePortfolio(id: Int, portfolio: Portfolio) {
        TODO("Not yet implemented")
    }

    override suspend fun deletePortfolio(id: Int) {
        TODO("Not yet implemented")
    }
}
