package data

import data.datasource.interfaces.PortfolioDataSource
import domain.entity.Portfolio
import domain.repository.PortfolioRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PortfolioRepositoryImpl @Inject constructor(
    private val dataSource: PortfolioDataSource
) : PortfolioRepository {
    override suspend fun getPortfolios(): List<Portfolio> {
        return withContext(Dispatchers.IO) {
            dataSource.getPortfolios()
        }
    }

    override suspend fun getPortfolioByListPosition(position: Int): Portfolio? {
        return withContext(Dispatchers.IO) {
            dataSource.getPortfolioByListPosition(position)
        }
    }

    override suspend fun createPortfolio() {
        return withContext(Dispatchers.IO) {
            dataSource.createPortfolio()
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
