package domain.repository

import domain.entity.Portfolio

interface PortfolioRepository {
    suspend fun getPortfolios(): List<Portfolio>
    suspend fun getPortfolioById(id: Int): Portfolio?
    suspend fun createPortfolio()
    suspend fun createAndInitPortfolio(portfolio: Portfolio)
    suspend fun updatePortfolio(id: Int, portfolio: Portfolio)
    suspend fun deletePortfolio(id: Int)
}
