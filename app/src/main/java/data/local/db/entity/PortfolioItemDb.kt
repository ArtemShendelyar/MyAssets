package data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import domain.entity.Asset
import java.time.LocalDate

@Entity
data class PortfolioItemDb(
    @PrimaryKey val id: Int,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("asset")
    @Embedded
    val asset: Asset,
    @ColumnInfo("price_currency")
    val priceCurrency: String,
    @ColumnInfo("price_history")
    val priceHistory: Map<LocalDate, Double>
)
