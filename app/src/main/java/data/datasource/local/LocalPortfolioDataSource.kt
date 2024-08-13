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

    override suspend fun getPortfolioById(id: Int): Portfolio {
        return withContext(Dispatchers.IO) {
            ExamplePortfolioList.getPortfolioById(id)
        }
    }

    override suspend fun createPortfolio() {
        return withContext(Dispatchers.IO) {
            ExamplePortfolioList.createPortfolio()
        }
    }

    override suspend fun createAndInitPortfolio(portfolio: Portfolio) {
        return withContext(Dispatchers.IO) {
            ExamplePortfolioList.createAndInitPortfolio(portfolio)
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
