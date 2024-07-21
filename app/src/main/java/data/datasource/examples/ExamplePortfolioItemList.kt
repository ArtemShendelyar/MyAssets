package data.datasource.examples

import domain.entity.Bond
import domain.entity.Cash
import domain.entity.PortfolioItem
import domain.entity.Stock
import java.time.LocalDate

object ExamplePortfolioItemList {
    private val portfolioItemList = listOf(
        PortfolioItem(
            id = 1,
            name = "My dollars",
            priceCurrency = "USD",
            priceHistory = mapOf(
                LocalDate.of(2024, 7, 1) to 250.0
            ),
            asset = Cash(
                id = 1,
                currency = "USD"
            )
        ),
        PortfolioItem(
            id = 2,
            name = "My apple stocks",
            priceCurrency = "USD",
            priceHistory = mapOf(
                LocalDate.of(2024, 7, 1) to 250.0
            ),
            asset = Stock(
                id = 1,
                ticker = "AAPL"
            )
        ),
        PortfolioItem(
            id = 2,
            name = "My US Savings Bond",
            priceCurrency = "USD",
            priceHistory = mapOf(
                LocalDate.of(2024, 7, 1) to 1000.0
            ),
            asset = Bond(
                id = 1,
                issueDate = LocalDate.of(2024, 6, 29),
                maturityDate = LocalDate.of(2024, 7, 29),
                nominalPrice = 1000.0,
                couponPayments = mapOf(
                    LocalDate.of(2024, 7, 14) to 10.0
                )
            )
        )
    )

    fun getPortfolioItemList() = portfolioItemList
}
