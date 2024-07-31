package com.example.myassets.presentation.ui.portfolios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.entity.Portfolio
import domain.interactors.PortfolioInteractor
import javax.inject.Inject

@HiltViewModel
class PortfolioListViewModel @Inject constructor(
    private val portfolioInteractor: PortfolioInteractor
) : ViewModel() {
    private val _portfolioList = MutableLiveData<List<Portfolio>>()
    val portfolioList: LiveData<List<Portfolio>> get() = _portfolioList

    init {
        _portfolioList.value = portfolioInteractor.getPortfolioList()
    }
}
