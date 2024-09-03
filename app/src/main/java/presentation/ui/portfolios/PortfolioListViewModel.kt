package presentation.ui.portfolios

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
class PortfolioListViewModel @Inject constructor(
    private val portfolioInteractor: PortfolioInteractor
) : ViewModel() {
    private val _portfolioList = MutableLiveData<List<Portfolio>>()
    val portfolioList: LiveData<List<Portfolio>> get() = _portfolioList

    init {
        viewModelScope.launch {
            portfolioInteractor.getPortfolioList().collect {
                _portfolioList.value = it
            }
        }
    }

    fun createPortfolio(name: String) {
        viewModelScope.launch {
            portfolioInteractor.createPortfolio(name)
        }
    }
}
