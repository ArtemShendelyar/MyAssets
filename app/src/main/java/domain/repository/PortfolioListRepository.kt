package domain.repository

import domain.entity.Portfolio

interface PortfolioListRepository {
    fun getPortfolios(): List<Portfolio>
}
