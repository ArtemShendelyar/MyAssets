package data.datasource.examples

import domain.entity.Portfolio

object ExamplePortfolioList {
    private val portfolioList = listOf(
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
}
