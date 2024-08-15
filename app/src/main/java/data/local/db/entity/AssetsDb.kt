package data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

open class AssetsDb(
    open val id: Int
)

@Entity
data class CashDb(
    @PrimaryKey override val id: Int,
    @ColumnInfo("currency")
    val currency: String
) : AssetsDb(id)

@Entity
data class StockDb(
    @PrimaryKey override val id: Int,
    @ColumnInfo("ticker")
    val ticker: String
) : AssetsDb(id)

@Entity
data class BondDb(
    @PrimaryKey override val id: Int,
    @ColumnInfo("issue_date")
    val issueDate: LocalDate,
    @ColumnInfo("maturity_date")
    val maturityDate: LocalDate,
    @ColumnInfo("nominal_price")
    val nominalPrice: Double,
    @ColumnInfo("coupon_payments")
    val couponPayments: Map<LocalDate, Double>
) : AssetsDb(id)
