package domain.interactors

import domain.entity.Portfolio
import domain.repository.PortfolioRepository
import domain.utils.resultOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PortfolioInteractor @Inject constructor(
    private val portfolioRepository: PortfolioRepository
) {
    suspend fun getPortfolioList(): List<Portfolio> {
        return portfolioRepository.getPortfolios()
    }

    suspend fun getPortfolioById(id: Int): Result<Portfolio> {
        return resultOf {
            portfolioRepository.getPortfolioById(id)
                ?: throw Exception("Null Portfolio Item")
        }
    }

    suspend fun createPortfolio() {
        portfolioRepository.createPortfolio()
    }

    suspend fun updatePortfolio(id: Int, portfolio: Portfolio) {
        portfolioRepository.updatePortfolio(id, portfolio)
    }

    suspend fun renamePortfolio(id: Int, newName: String) {
        val renamedPortfolioResult = getPortfolioById(id)
        val renamedPortfolio = renamedPortfolioResult.getOrThrow()
        portfolioRepository.deletePortfolio(id)
        portfolioRepository.createAndInitPortfolio(renamedPortfolio.copy(name = newName))
    }

    suspend fun deletePortfolio(id: Int) {
        portfolioRepository.deletePortfolio(id)
    }
}
