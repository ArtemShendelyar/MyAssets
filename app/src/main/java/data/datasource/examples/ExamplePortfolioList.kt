package data.datasource.examples

import domain.entity.Portfolio

object ExamplePortfolioList {
    private val portfolioList = mutableListOf(
        Portfolio(
            id = 0,
            name = "My first portfolio"
        ),
        Portfolio(
            id = 1,
            name = "My second portfolio"
        ),
        Portfolio(
            id = 2,
            name = "My third portfolio"
        )
    )

    fun getPortfolioList() = portfolioList

    fun getPortfolioById(id: Int): Portfolio {
        return portfolioList.find { portfolio -> portfolio.id == id }
            ?: throw NoSuchElementException("Portfolio with ID '$id' not found.")
    }

    fun createPortfolio(name: String) {
        val newPortfolio = Portfolio(
            id = portfolioList.size,
            name = name
        )
        portfolioList.add(newPortfolio)
    }

    fun createAndInitPortfolio(portfolio: Portfolio) {
        portfolioList.add(portfolio)
    }

    fun updatePortfolio(id: Int, portfolio: Portfolio) {
        portfolioList[id] = portfolio
    }

    fun deletePortfolio(id: Int) {
        try {
            val index = portfolioList.indexOfFirst { portfolio -> portfolio.id == id }
            portfolioList.removeAt(index)
        } catch (e: IndexOutOfBoundsException) {
            throw NoSuchElementException("Portfolio with ID '$id' not found.")
        }
    }
}
