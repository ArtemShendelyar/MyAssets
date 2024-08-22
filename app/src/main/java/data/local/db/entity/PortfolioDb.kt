package data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import domain.entity.Portfolio

@Entity(tableName = "portfolio_list")
data class PortfolioDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Int = 0,
    @ColumnInfo("name")
    val name: String
)

fun PortfolioDb.toDomain(): Portfolio {
    val portfolio = Portfolio(id, name)
    return portfolio
}
