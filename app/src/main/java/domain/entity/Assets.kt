package domain.entity

import java.time.LocalDate

open class Asset(
    open val id: Int
)

data class Cash(
    override val id: Int,
    val currency: String
) : Asset(id)

data class Stock(
    override val id: Int,
    val ticker: String
) : Asset(id)

data class Bond(
    override val id: Int,
    val issueDate: LocalDate,
    val maturityDate: LocalDate,
    val nominalPrice: Double,
    val couponPayments: Map<LocalDate, Double>
) : Asset(id)
