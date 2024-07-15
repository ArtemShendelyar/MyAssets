package domain.entity

import java.util.Date

open class Asset(
    open val id: Int,
    open val name: String
)

data class Cash(
    override val id: Int,
    override val name: String,
    val currency: String
) : Asset(id, name)

data class Stock(
    override val id: Int,
    override val name: String,
    val dividendYearPercentage: Double
) : Asset(id, name)

data class Bond(
    override val id: Int,
    override val name: String,
    val couponYearPercentage: Double,
    val maturityDate: Date
) : Asset(id, name)
