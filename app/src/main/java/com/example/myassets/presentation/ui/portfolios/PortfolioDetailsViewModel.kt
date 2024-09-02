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
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun fetchPortfolioById(id: Int) {
        viewModelScope.launch {
            _portfolio.value = portfolioInteractor.getPortfolioById(id)
        }
    }

    fun renamePortfolio(portfolioId: Int, newName: String) {
        viewModelScope.launch {
            try {
                portfolioInteractor.updatePortfolio(portfolioId, Portfolio(portfolioId, newName))
                fetchPortfolioById(portfolioId)
            } catch (e: Exception) {
                _error.value = e.toString()
            }
        }
    }

    fun deletePortfolio(portfolioId: Int) {
        viewModelScope.launch {
            try {
                portfolioInteractor.deletePortfolio(portfolioId)
            } catch (e: Exception) {
                _error.value = e.toString()
            }
        }
    }

    fun resetError() {
        _error.value = null
    }
}
