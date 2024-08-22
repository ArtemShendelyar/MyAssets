package data

import data.datasource.interfaces.PortfolioDataSource
import data.local.db.dao.PortfolioDao
import data.local.db.entity.PortfolioDb
import data.local.db.entity.toDomain
import domain.entity.Portfolio
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PortfolioDbDataSource @Inject constructor(
    private val portfolioDao: PortfolioDao
) : PortfolioDataSource {
    override suspend fun getPortfolios(): Flow<List<Portfolio>> {
        val list = portfolioDao.getPortfolioList()
        return list.map { it ->
            it.map {
                it.toDomain()
            }
        }
    }

    override suspend fun getPortfolioById(id: Int): Flow<Portfolio> {
        val portfolio = portfolioDao.getPortfolioById(id)
        return portfolio.map {
            it.toDomain()
        }
    }

    override suspend fun createPortfolio(name: String) {
        val portfolioDb = PortfolioDb(0, name)
        portfolioDao.upsertPortfolio(portfolioDb)
    }

    override suspend fun updatePortfolio(id: Int, portfolio: Portfolio) {
        val portfolioDb = PortfolioDb(id, portfolio.name)
        portfolioDao.upsertPortfolio(portfolioDb)
    }

    override suspend fun deletePortfolio(id: Int) {
        portfolioDao.deletePortfolioById(id)
    }
}
