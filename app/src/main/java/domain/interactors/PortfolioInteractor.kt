package domain.interactors

import domain.entity.Portfolio
import domain.repository.PortfolioRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PortfolioInteractor @Inject constructor(
    private val portfolioRepository: PortfolioRepository
) {
    fun getPortfolioList(): List<Portfolio> {
        return portfolioRepository.getPortfolios()
    }

    fun getPortfolioById(id: Int): Result<Portfolio> {
        try {
            val requiredPortfolio =
                portfolioRepository.getPortfolioById(id) ?: throw Exception("Null Portfolio")
            return Result.success(requiredPortfolio)
        } catch (exception: Exception) {
            return Result.failure(exception)
        }
    }

    fun createPortfolio(portfolio: Portfolio) {
        portfolioRepository.createPortfolio(portfolio)
    }

    fun updatePortfolio(id: Int, portfolio: Portfolio) {
        portfolioRepository.updatePortfolio(id, portfolio)
    }

    fun deletePortfolio(id: Int) {
        portfolioRepository.deletePortfolio(id)
    }
}
