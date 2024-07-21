package domain.repository

import domain.entity.PortfolioItem

interface PortfolioItemRepository {
    fun getPortfolioItems(): List<PortfolioItem>
    fun getPortfolioItemById(id: Int): PortfolioItem?
    fun createPortfolioItem(portfolioItem: PortfolioItem)
    fun updatePortfolioItem(id: Int, portfolioItem: PortfolioItem)
    fun deletePortfolioItem(id: Int)
}
