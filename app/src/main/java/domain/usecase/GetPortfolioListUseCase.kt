package domain.usecase

import domain.entity.Portfolio
import domain.repository.PortfolioListRepository

class GetPortfolioListUseCase(private val portfolioListRepository: PortfolioListRepository) {
    operator fun invoke(): List<Portfolio> {
        return portfolioListRepository.getPortfolios()
    }
}
