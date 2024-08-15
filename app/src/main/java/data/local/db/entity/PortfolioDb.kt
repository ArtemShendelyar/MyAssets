package data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import domain.entity.Portfolio

@Entity(tableName = "portfolio_list")
data class PortfolioDb(
    @PrimaryKey
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("name")
    val name: String
)

fun PortfolioDb.toDomain(): Portfolio {
    val portfolio = Portfolio(id, name)
    return portfolio
}
