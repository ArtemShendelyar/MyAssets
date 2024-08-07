package domain.interactors

import domain.entity.PortfolioItem
import domain.repository.PortfolioItemRepository
import domain.utils.resultOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PortfolioItemInteractor @Inject constructor(
    private val portfolioItemRepository: PortfolioItemRepository
) {
    suspend fun getPortfolioItemsList(): List<PortfolioItem> {
        return portfolioItemRepository.getPortfolioItems()
    }

    suspend fun getPortfolioItemById(id: Int): Result<PortfolioItem> {
        return resultOf {
            portfolioItemRepository.getPortfolioItemById(id)
                ?: throw Exception("Null Portfolio Item")
        }
    }

    suspend fun createPortfolioItem(portfolioItem: PortfolioItem) {
        portfolioItemRepository.createPortfolioItem(portfolioItem)
    }

    suspend fun updatePortfolioItem(id: Int, portfolioItem: PortfolioItem) {
        portfolioItemRepository.updatePortfolioItem(id, portfolioItem)
    }

    suspend fun deletePortfolioItem(id: Int) {
        portfolioItemRepository.deletePortfolioItem(id)
    }
}
