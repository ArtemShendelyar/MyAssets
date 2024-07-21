package data.datasource.local

import data.datasource.examples.ExamplePortfolioItemList
import data.datasource.interfaces.PortfolioItemDataSource
import domain.entity.PortfolioItem
import javax.inject.Inject

class LocalPortfolioItemDataSource @Inject constructor() : PortfolioItemDataSource {
    override fun getPortfolioItems(): List<PortfolioItem> {
        return ExamplePortfolioItemList.getPortfolioItemList()
    }
}
