package data.datasource.local

import data.datasource.examples.ExamplePortfolioItemList
import data.datasource.interfaces.PortfolioItemDataSource
import domain.entity.PortfolioItem
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalPortfolioItemDataSource @Inject constructor() : PortfolioItemDataSource {
    override suspend fun getPortfolioItems(): List<PortfolioItem> {
        return withContext(Dispatchers.IO) {
            ExamplePortfolioItemList.getPortfolioItemList()
        }
    }

    override suspend fun getPortfolioItemById(id: Int): PortfolioItem {
        return withContext(Dispatchers.IO) {
            ExamplePortfolioItemList.getPortfolioItemById(id)
        }
    }

    override suspend fun createPortfolioItem(portfolioItem: PortfolioItem) {
        return withContext(Dispatchers.IO) {
            createPortfolioItem(portfolioItem)
        }
    }

    override suspend fun updatePortfolioItem(id: Int, portfolioItem: PortfolioItem) {
        return withContext(Dispatchers.IO) {
            updatePortfolioItem(id, portfolioItem)
        }
    }

    override suspend fun deletePortfolioItem(id: Int) {
        return withContext(Dispatchers.IO) {
            deletePortfolioItem(id)
        }
    }
}
