package domain.repository

import domain.entity.PortfolioItem

interface PortfolioItemRepository {
    suspend fun getPortfolioItems(): List<PortfolioItem>
    suspend fun getPortfolioItemById(id: Int): PortfolioItem?
    suspend fun createPortfolioItem(portfolioItem: PortfolioItem)
    suspend fun updatePortfolioItem(id: Int, portfolioItem: PortfolioItem)
    suspend fun deletePortfolioItem(id: Int)
}
