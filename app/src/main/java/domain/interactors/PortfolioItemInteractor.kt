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
    fun getPortfolioItemsList(): List<PortfolioItem> {
        return portfolioItemRepository.getPortfolioItems()
    }

    fun getPortfolioItemById(id: Int): Result<PortfolioItem> {
        return resultOf {
            portfolioItemRepository.getPortfolioItemById(id)
                ?: throw Exception("Null Portfolio Item")
        }
    }

    fun createPortfolioItem(portfolioItem: PortfolioItem) {
        portfolioItemRepository.createPortfolioItem(portfolioItem)
    }

    fun updatePortfolioItem(id: Int, portfolioItem: PortfolioItem) {
        portfolioItemRepository.updatePortfolioItem(id, portfolioItem)
    }

    fun deletePortfolioItem(id: Int) {
        portfolioItemRepository.deletePortfolioItem(id)
    }
}
