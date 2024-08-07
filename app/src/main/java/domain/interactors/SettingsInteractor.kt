package domain.interactors

import domain.repository.DataStoreRepository
import javax.inject.Inject

class SettingsInteractor @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    companion object {
        private const val APP_LANGUAGE_KEY = "AppLanguage"
        private const val GLOBAL_CURRENCY_KEY = "GlobalCurrency"
        private const val DEFAULT_CURRENCY = "BYN"
        private const val DEFAULT_LANGUAGE = "Русский"
    }

    suspend fun setGlobalCurrency(currency: String) {
        dataStoreRepository.putString(GLOBAL_CURRENCY_KEY, currency)
    }

    suspend fun getGlobalCurrency(): String {
        return dataStoreRepository.getString(GLOBAL_CURRENCY_KEY) ?: DEFAULT_CURRENCY
    }

    suspend fun setAppLanguage(language: String) {
        dataStoreRepository.putString(APP_LANGUAGE_KEY, language)
    }

    suspend fun getAppLanguage(): String {
        return dataStoreRepository.getString(APP_LANGUAGE_KEY) ?: DEFAULT_LANGUAGE
    }
}
