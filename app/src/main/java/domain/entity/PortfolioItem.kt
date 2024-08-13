package domain.entity

import java.time.LocalDate

data class PortfolioItem(
    val id: Int,
    val name: String,
    val asset: Asset,
    val priceCurrency: String,
    val priceHistory: Map<LocalDate, Double>
)
