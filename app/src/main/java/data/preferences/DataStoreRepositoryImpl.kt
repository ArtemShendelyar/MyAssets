package data.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import domain.repository.DataStoreRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.first

class DataStoreRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : DataStoreRepository {

    companion object {
        private const val DEFAULT_CURRENCY_KEY = "CURRENCY_KEY"
        private const val DEFAULT_CURRENCY = "BYN"
    }

    override suspend fun getDefaultCurrency(): String? {
        return try {
            val prefKey = stringPreferencesKey(DEFAULT_CURRENCY_KEY)
            val preference = dataStore.data.first()
            preference[prefKey] ?: DEFAULT_CURRENCY
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun setDefaultCurrency(value: String) {
        val prefKey = stringPreferencesKey(DEFAULT_CURRENCY_KEY)
        dataStore.edit {
            it[prefKey] = value
        }
    }
}
