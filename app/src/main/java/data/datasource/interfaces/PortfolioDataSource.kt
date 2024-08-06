package data.datasource.interfaces

import domain.entity.Portfolio

interface PortfolioDataSource {
    suspend fun getPortfolios(): List<Portfolio>
    suspend fun getPortfolioById(id: Int): Portfolio?
    suspend fun createPortfolio()
    suspend fun updatePortfolio(id: Int, portfolio: Portfolio)
    suspend fun deletePortfolio(id: Int)
}
