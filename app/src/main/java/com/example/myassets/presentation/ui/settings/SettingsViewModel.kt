package com.example.myassets.presentation.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.interactors.SettingsInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsInteractor: SettingsInteractor
): ViewModel() {
    private val _currentCurrency = MutableLiveData<String>()
    private val _currentLanguage = MutableLiveData<String>()
    val defaultCurrency: LiveData<String>
        get() = _currentCurrency
    val defaultLanguage: LiveData<String>
        get() = _currentLanguage

    init {
        fetchGlobalCurrency()
        fetchAppLanguage()
    }

    fun saveGlobalCurrency(currency: String) {
        _currentCurrency.value = currency
        viewModelScope.launch {
            settingsInteractor.setGlobalCurrency(currency)
        }
    }

    fun saveAppLanguage(language: String) {
        _currentLanguage.value = language
        viewModelScope.launch {
            settingsInteractor.setAppLanguage(language)
        }
    }

    private fun fetchGlobalCurrency() {
        viewModelScope.launch {
            _currentCurrency.value = settingsInteractor.getGlobalCurrency()?:"BYN"
        }
    }
    private fun fetchAppLanguage() {
        viewModelScope.launch {
            _currentLanguage.value = settingsInteractor.getAppLanguage()?:"Russian"
        }
    }
}
