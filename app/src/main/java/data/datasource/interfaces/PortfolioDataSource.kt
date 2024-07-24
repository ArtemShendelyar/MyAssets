package data.datasource.interfaces

import domain.entity.Portfolio

interface PortfolioDataSource {
    fun getPortfolios(): List<Portfolio>
}
