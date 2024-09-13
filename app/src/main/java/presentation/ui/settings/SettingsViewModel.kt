package presentation.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.interactors.SettingsInteractor
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsInteractor: SettingsInteractor
) : ViewModel() {
    private val _currentCurrency = MutableLiveData<String>()
    val currentCurrency: LiveData<String>
        get() = _currentCurrency

    init {
        fetchGlobalCurrency()
    }

    fun saveGlobalCurrency(currency: String) {
        viewModelScope.launch {
            _currentCurrency.value = currency
            settingsInteractor.setGlobalCurrency(currency)
        }
    }

    private fun fetchGlobalCurrency() {
        viewModelScope.launch {
            _currentCurrency.value = settingsInteractor.getGlobalCurrency()
        }
    }
}
