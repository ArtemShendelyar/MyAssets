package domain.repository

import domain.entity.Portfolio

interface PortfolioRepository {
    fun getPortfolios(): List<Portfolio>
    fun getPortfolioById(id: Int): Portfolio?
    fun createPortfolio(portfolio: Portfolio)
    fun updatePortfolio(id: Int, portfolio: Portfolio)
    fun deletePortfolio(id: Int)
}
