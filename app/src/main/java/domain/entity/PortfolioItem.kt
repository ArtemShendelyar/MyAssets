package domain.entity

import java.util.Date

data class PortfolioItem(
    val id: Int,
    val asset: Asset,
    val priceCurrency: String,
    val priceHistory: Map<Date, Double>
)
