package data.datasource.examples

import domain.entity.Portfolio

object ExamplePortfolioList {
    private val portfolioList = mutableListOf(
        Portfolio(
            id = 1,
            name = "My first portfolio"
        ),
        Portfolio(
            id = 2,
            name = "My second portfolio"
        ),
        Portfolio(
            id = 3,
            name = "My third portfolio"
        )
    )

    fun getPortfolioList() = portfolioList

    fun getPortfolioById(id: Int) = portfolioList.elementAt(id)

    fun createPortfolio() {
        val newPortfolio = Portfolio(
            id = portfolioList.size,
            name = "New portfolio"
        )
        portfolioList.add(newPortfolio)
    }

    fun updatePortfolio(id: Int, portfolio: Portfolio) {
        portfolioList[id] = portfolio
    }

    fun deletePortfolio(id: Int) {
        portfolioList.removeAt(id)
    }
}
