package domain.interactors

import domain.entity.Portfolio
import domain.repository.PortfolioRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
class PortfolioInteractor @Inject constructor(
    private val portfolioRepository: PortfolioRepository
) {
    suspend fun getPortfolioList(): Flow<List<Portfolio>> {
        return portfolioRepository.getPortfolios()
    }

    suspend fun getPortfolioById(id: Int): Flow<Portfolio> {
        return portfolioRepository.getPortfolioById(id)
    }

    suspend fun createPortfolio(name: String) {
        portfolioRepository.createPortfolio(name)
    }

    suspend fun updatePortfolio(id: Int, portfolio: Portfolio) {
        portfolioRepository.updatePortfolio(id, portfolio)
    }

    suspend fun deletePortfolio(id: Int) {
        portfolioRepository.deletePortfolio(id)
    }
}
