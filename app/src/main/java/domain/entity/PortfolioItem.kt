package domain.entity

import java.time.LocalDate

data class PortfolioItem(
    val id: Int,
    var name: String,
    var asset: Asset,
    var priceCurrency: String,
    var priceHistory: Map<LocalDate, Double>
)
