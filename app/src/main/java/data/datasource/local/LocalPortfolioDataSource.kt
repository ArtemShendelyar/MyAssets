package data.datasource.local

import data.datasource.examples.ExamplePortfolioList
import data.datasource.interfaces.PortfolioDataSource
import domain.entity.Portfolio
import javax.inject.Inject

class LocalPortfolioDataSource @Inject constructor() : PortfolioDataSource {
    override fun getPortfolios(): List<Portfolio> {
        return ExamplePortfolioList.getPortfolioList()
    }
}
