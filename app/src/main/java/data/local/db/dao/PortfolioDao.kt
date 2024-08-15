package data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import data.local.db.entity.PortfolioDb

@Dao
interface PortfolioDao {
    @Insert(entity = PortfolioDb::class)
    fun createPortfolio(portfolio: PortfolioDb)

    @Query("DELETE FROM portfolio_list WHERE portfolio_list.id == :portfolioId")
    fun deletePortfolioById(portfolioId: Int)

    @Query("SELECT * FROM portfolio_list")
    fun getPortfolioList(): List<PortfolioDb>

    @Query("SELECT * FROM portfolio_list WHERE portfolio_list.id == :portfolioId")
    fun getPortfolioById(portfolioId: Int): PortfolioDb

    @Update(entity = PortfolioDb::class)
    fun updatePortfolio(portfolioDb: PortfolioDb)

    @Query("SELECT COUNT(*) FROM portfolio_list")
    fun getSize(): Int
}
