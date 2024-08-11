package com.example.myassets.presentation.ui.portfolios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.entity.Portfolio
import domain.interactors.PortfolioInteractor
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class PortfolioDetailsViewModel @Inject constructor(
    private val portfolioInteractor: PortfolioInteractor
) : ViewModel() {
    private val _portfolio = MutableLiveData<Portfolio>()
    val portfolio: LiveData<Portfolio> get() = _portfolio

    fun fetchPortfolioById(id: Int) {
        viewModelScope.launch {
            val portfolioResult = portfolioInteractor.getPortfolioByListPosition(id)
            _portfolio.value = portfolioResult.getOrThrow()
        }
    }

    fun renamePortfolio(portfolioId: Int, newName: String) {
        viewModelScope.launch {
            val renamedPortfolioResult = portfolioInteractor.getPortfolioByListPosition(portfolioId)
            var renamedPortfolio = renamedPortfolioResult.getOrThrow()
            renamedPortfolio.name = newName
            portfolioInteractor.updatePortfolio(portfolioId, renamedPortfolio)
        }
        fetchPortfolioById(portfolioId)
    }

    fun deletePortfolio(portfolioId: Int) {
        viewModelScope.launch {
            portfolioInteractor.deletePortfolio(portfolioId)
        }
    }
}
