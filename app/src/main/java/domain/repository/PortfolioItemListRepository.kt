package domain.repository

import domain.entity.PortfolioItem

interface PortfolioItemListRepository {
    fun getPortfolioItems(): List<PortfolioItem>
}
