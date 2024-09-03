package presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.interactors.PortfolioInteractor
import domain.interactors.PortfolioItemInteractor
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val portfolioItemInteractor: PortfolioItemInteractor,
    private val portfolioInteractor: PortfolioInteractor
) : ViewModel() {
    private val _portfoliosCount = MutableLiveData<Int>()
    val portfoliosCount: LiveData<Int> get() = _portfoliosCount
    private val _assetsCount = MutableLiveData<Int>()
    val assetsCount: LiveData<Int> get() = _assetsCount

    fun fetchStats() {
        viewModelScope.launch {
            _assetsCount.value = portfolioItemInteractor.getPortfolioItemsList().count()
            portfolioInteractor.getPortfolioList().collect {
                _portfoliosCount.value = it.count()
            }
        }
    }
}
