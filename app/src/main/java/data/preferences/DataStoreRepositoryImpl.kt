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
    override suspend fun putString(key: String, value: String) {
        val prefKey = stringPreferencesKey(key)
        dataStore.edit {
            it[prefKey] = value
        }
    }

    override suspend fun getString(key: String): String? {
        return try {
            val prefKey = stringPreferencesKey(key)
            val preference = dataStore.data.first()
            preference[prefKey]
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun clearPreference(key: String) {
        val prefKey = stringPreferencesKey(key)
        dataStore.edit {
            if (it.contains(prefKey)) {
                it.remove(prefKey)
            }
        }
    }
}
