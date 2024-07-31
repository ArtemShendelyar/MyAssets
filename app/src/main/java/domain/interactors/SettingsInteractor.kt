package domain.interactors

import domain.repository.DataStoreRepository
import javax.inject.Inject

class SettingsInteractor @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {

    suspend fun setGlobalCurrency(currency: String) {
        dataStoreRepository.putString("GlobalCurrency", currency)
    }

    suspend fun getGlobalCurrency(): String? {
        return dataStoreRepository.getString("GlobalCurrency")
    }

    suspend fun setAppLanguage(language: String) {
        dataStoreRepository.putString("AppLanguage", language)
    }

    suspend fun getAppLanguage(): String? {
        return dataStoreRepository.getString("AppLanguage")
    }
}
