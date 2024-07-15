package domain.usecase

import domain.entity.PortfolioItem
import domain.repository.PortfolioItemListRepository

class GetPortfolioItemListUseCase(
    private val portfolioItemListRepository: PortfolioItemListRepository
) {
    operator fun invoke(): List<PortfolioItem> {
        return portfolioItemListRepository.getPortfolioItems()
    }
}
