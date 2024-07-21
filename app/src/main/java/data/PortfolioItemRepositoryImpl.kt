package data

import data.datasource.interfaces.PortfolioItemDataSource
import domain.entity.PortfolioItem
import domain.repository.PortfolioItemRepository
import javax.inject.Inject

class PortfolioItemRepositoryImpl @Inject constructor(
    private val dataSource: PortfolioItemDataSource
) : PortfolioItemRepository {
    override fun getPortfolioItems(): List<PortfolioItem> {
        return dataSource.getPortfolioItems()
    }

    override fun getPortfolioItemById(id: Int): PortfolioItem? {
        TODO("Not yet implemented")
    }

    override fun createPortfolioItem(portfolioItem: PortfolioItem) {
        TODO("Not yet implemented")
    }

    override fun deletePortfolioItem(id: Int) {
        TODO("Not yet implemented")
    }

    override fun updatePortfolioItem(id: Int, portfolioItem: PortfolioItem) {
        TODO("Not yet implemented")
    }
}
