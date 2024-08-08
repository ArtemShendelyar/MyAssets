package domain.interactors

import domain.repository.DataStoreRepository
import javax.inject.Inject

class SettingsInteractor @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    suspend fun setGlobalCurrency(currency: String) {
        dataStoreRepository.setDefaultCurrency(currency)
    }

    suspend fun getGlobalCurrency(): String? {
        return dataStoreRepository.getDefaultCurrency()
    }

}
