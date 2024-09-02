package data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import data.local.db.entity.PortfolioDb
import kotlinx.coroutines.flow.Flow

@Dao
interface PortfolioDao {
    @Upsert(entity = PortfolioDb::class)
    fun upsertPortfolio(portfolioDb: PortfolioDb)

    @Query("DELETE FROM portfolio_list WHERE portfolio_list.id == :portfolioId")
    fun deletePortfolioById(portfolioId: Int)

    @Query("SELECT * FROM portfolio_list")
    fun getPortfolioList(): Flow<List<PortfolioDb>>

    @Query("SELECT * FROM portfolio_list WHERE portfolio_list.id == :portfolioId")
    fun getPortfolioById(portfolioId: Int): PortfolioDb
}
