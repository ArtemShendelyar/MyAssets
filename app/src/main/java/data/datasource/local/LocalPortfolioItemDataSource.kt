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

    override suspend fun getPortfolioItemById(id: Int): PortfolioItem? {
        TODO("Not yet implemented")
    }

    override suspend fun createPortfolioItem(portfolioItem: PortfolioItem) {
        TODO("Not yet implemented")
    }

    override suspend fun updatePortfolioItem(id: Int, portfolioItem: PortfolioItem) {
        TODO("Not yet implemented")
    }

    override suspend fun deletePortfolioItem(id: Int) {
        TODO("Not yet implemented")
    }
}
