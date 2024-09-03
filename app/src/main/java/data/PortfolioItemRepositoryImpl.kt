package data

import data.datasource.interfaces.PortfolioItemDataSource
import domain.entity.PortfolioItem
import domain.repository.PortfolioItemRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PortfolioItemRepositoryImpl @Inject constructor(
    private val dataSource: PortfolioItemDataSource
) : PortfolioItemRepository {
    override suspend fun getPortfolioItems(): List<PortfolioItem> {
        return withContext(Dispatchers.IO) {
            dataSource.getPortfolioItems()
        }
    }

    override suspend fun getPortfolioItemById(id: Int): PortfolioItem? {
        return withContext(Dispatchers.IO) {
            dataSource.getPortfolioItemById(id)
        }
    }

    override suspend fun createPortfolioItem(portfolioItem: PortfolioItem) {
        return withContext(Dispatchers.IO) {
            dataSource.createPortfolioItem(portfolioItem)
        }
    }

    override suspend fun deletePortfolioItem(id: Int) {
        return withContext(Dispatchers.IO) {
            dataSource.deletePortfolioItem(id)
        }
    }

    override suspend fun updatePortfolioItem(id: Int, portfolioItem: PortfolioItem) {
        return withContext(Dispatchers.IO) {
            updatePortfolioItem(id, portfolioItem)
        }
    }
}
