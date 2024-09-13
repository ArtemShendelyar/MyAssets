package presentation.ui.assets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.entity.PortfolioItem
import domain.interactors.PortfolioItemInteractor
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class AssetListViewModel @Inject constructor(
    private val portfolioItemInteractor: PortfolioItemInteractor
) : ViewModel() {
    private val _portfolioItemsList = MutableLiveData<List<PortfolioItem>>()
    val portfolioItemsList: LiveData<List<PortfolioItem>> get() = _portfolioItemsList

    init {
        fetchPortfolioItemsList()
    }

    private fun fetchPortfolioItemsList() {
        viewModelScope.launch {
            _portfolioItemsList.value = portfolioItemInteractor.getPortfolioItemsList()
        }
    }
}
