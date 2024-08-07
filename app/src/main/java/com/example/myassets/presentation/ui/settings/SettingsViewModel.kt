package com.example.myassets.presentation.ui.settings

import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.interactors.SettingsInteractor
import javax.inject.Inject
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsInteractor: SettingsInteractor
) : ViewModel() {
    private val _currentCurrency = MutableLiveData<String>()
    val currentCurrency: LiveData<String>
        get() = _currentCurrency

    private val _currentLanguage = MutableLiveData<String>()
    val currentLanguage: LiveData<String>
        get() = _currentLanguage

    init {
        fetchGlobalCurrency()
        fetchAppLanguage()
    }

    fun saveGlobalCurrency(currency: String) {
        viewModelScope.launch {
            flowOf(currency).collect {
                _currentCurrency.value = it
            }
            settingsInteractor.setGlobalCurrency(currency)
        }
    }

    fun saveAppLanguage(language: String, languageStringUI: String) {
        _currentLanguage.value = languageStringUI
        viewModelScope.launch {
            flowOf(languageStringUI).collect {
                _currentLanguage.value = it
            }
            settingsInteractor.setAppLanguage(language)
            val appLocale: LocaleListCompat = LocaleListCompat.forLanguageTags(language)
            AppCompatDelegate.setApplicationLocales(appLocale)
        }
    }

    private fun fetchGlobalCurrency() {
        viewModelScope.launch {
            _currentCurrency.value = settingsInteractor.getGlobalCurrency()
        }
    }

    private fun fetchAppLanguage() {
        viewModelScope.launch {
            _currentLanguage.value = settingsInteractor.getAppLanguage()
        }
    }
}
