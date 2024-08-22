package domain.repository

import domain.entity.Portfolio
import kotlinx.coroutines.flow.Flow

interface PortfolioRepository {
    suspend fun getPortfolios(): Flow<List<Portfolio>>
    suspend fun getPortfolioById(id: Int): Flow<Portfolio>
    suspend fun createPortfolio(name: String)
    suspend fun updatePortfolio(id: Int, portfolio: Portfolio)
    suspend fun deletePortfolio(id: Int)
}
