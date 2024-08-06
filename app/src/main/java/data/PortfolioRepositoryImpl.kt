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

    override suspend fun getPortfolioById(id: Int): Portfolio? {
        TODO("Not yet implemented")
    }

    override suspend fun createPortfolio(portfolio: Portfolio) {
        TODO("Not yet implemented")
    }

    override suspend fun deletePortfolio(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun updatePortfolio(id: Int, portfolio: Portfolio) {
        TODO("Not yet implemented")
    }
}
