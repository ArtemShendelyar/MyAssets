package data.datasource.interfaces

import domain.entity.PortfolioItem

interface PortfolioItemDataSource {
    fun getPortfolioItems(): List<PortfolioItem>
}
