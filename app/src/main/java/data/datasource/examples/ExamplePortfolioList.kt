package data.datasource.examples

import domain.entity.Portfolio

object ExamplePortfolioList {
    private val portfolioList = listOf(
        Portfolio(
            id = 1,
            name = "My first portfolio"
        )
    )

    fun getPortfolioList() = portfolioList
}
