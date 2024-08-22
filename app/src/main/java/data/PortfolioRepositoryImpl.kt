package data

import domain.entity.Portfolio
import domain.repository.PortfolioRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class PortfolioRepositoryImpl @Inject constructor(
    private val dataSource: PortfolioDbDataSource
) : PortfolioRepository {
    override suspend fun getPortfolios(): Flow<List<Portfolio>> {
        return withContext(Dispatchers.IO) {
            dataSource.getPortfolios()
        }
    }

    override suspend fun getPortfolioById(id: Int): Portfolio {
        return withContext(Dispatchers.IO) {
            dataSource.getPortfolioById(id)
        }
    }

    override suspend fun createPortfolio(name: String) {
        return withContext(Dispatchers.IO) {
            dataSource.createPortfolio(name)
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
