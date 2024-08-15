package data

import domain.entity.Portfolio
import domain.repository.PortfolioRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PortfolioRepositoryImpl @Inject constructor(
    private val dataSource: PortfolioDbDataSource
) : PortfolioRepository {
    override suspend fun getPortfolios(): List<Portfolio> {
        return withContext(Dispatchers.IO) {
            dataSource.getPortfolios()
        }
    }

    override suspend fun getPortfolioById(id: Int): Portfolio? {
        return withContext(Dispatchers.IO) {
            dataSource.getPortfolioById(id)
        }
    }

    override suspend fun createPortfolio() {
        return withContext(Dispatchers.IO) {
            dataSource.createPortfolio()
        }
    }

    override suspend fun createAndInitPortfolio(portfolio: Portfolio) {
        return withContext(Dispatchers.IO) {
            dataSource.createAndInitPortfolio(portfolio)
        }
    }

    override suspend fun deletePortfolio(id: Int) {
        return withContext(Dispatchers.IO) {
            dataSource.deletePortfolio(id)
        }
    }

    override suspend fun updatePortfolio(id: Int, portfolio: Portfolio) {
        return withContext(Dispatchers.IO) {
            dataSource.updatePortfolio(id, portfolio)
        }
    }
}
