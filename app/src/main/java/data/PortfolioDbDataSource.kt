package data

import data.datasource.interfaces.PortfolioDataSource
import data.local.db.dao.PortfolioDao
import data.local.db.entity.PortfolioDb
import data.local.db.entity.toDomain
import domain.entity.Portfolio
import javax.inject.Inject
import kotlin.random.Random

class PortfolioDbDataSource @Inject constructor(
    private val portfolioDao: PortfolioDao
) : PortfolioDataSource {
    override suspend fun getPortfolios(): List<Portfolio> {
        val list = portfolioDao.getPortfolioList().map {
            it.toDomain()
        }
        return list
    }

    override suspend fun getPortfolioById(id: Int): Portfolio {
        val portfolio = portfolioDao.getPortfolioById(id).toDomain()
        return portfolio
    }

    override suspend fun createPortfolio() {
        val portfolioDb = PortfolioDb(Random.nextInt(), name = "New portfolio")
        portfolioDao.upsertPortfolio(portfolioDb)
    }

    override suspend fun createAndInitPortfolio(portfolio: Portfolio) {
        val portfolioDb = PortfolioDb(portfolio.id, portfolio.name)
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
