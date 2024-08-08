package domain.interactors

import domain.repository.DataStoreRepository
import javax.inject.Inject

class SettingsInteractor @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    companion object {
        private const val GLOBAL_CURRENCY_KEY = "GlobalCurrency"
        private const val DEFAULT_CURRENCY = "BYN"
    }

    suspend fun setGlobalCurrency(currency: String) {
        dataStoreRepository.putString(GLOBAL_CURRENCY_KEY, currency)
    }

    suspend fun getGlobalCurrency(): String {
        return dataStoreRepository.getString(GLOBAL_CURRENCY_KEY) ?: DEFAULT_CURRENCY
    }

}
