package data

import data.datasource.interfaces.PortfolioDataSource
import domain.entity.Portfolio
import domain.repository.PortfolioRepository
import javax.inject.Inject

class PortfolioRepositoryImpl @Inject constructor(
    private val dataSource: PortfolioDataSource
) : PortfolioRepository {
    override fun getPortfolios(): List<Portfolio> {
        return dataSource.getPortfolios()
    }

    override fun getPortfolioById(id: Int): Portfolio? {
        TODO("Not yet implemented")
    }

    override fun createPortfolio(portfolio: Portfolio) {
        TODO("Not yet implemented")
    }

    override fun deletePortfolio(id: Int) {
        TODO("Not yet implemented")
    }

    override fun updatePortfolio(id: Int, portfolio: Portfolio) {
        TODO("Not yet implemented")
    }
}
