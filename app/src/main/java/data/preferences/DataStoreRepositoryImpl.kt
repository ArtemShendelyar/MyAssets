package data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import domain.repository.DataStoreRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.first

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "Preferences")

class DataStoreRepositoryImpl @Inject constructor(
    private val context: Context
) : DataStoreRepository {
    override suspend fun putString(key: String, value: String) {
        val prefKey = stringPreferencesKey(key)
        context.dataStore.edit {
            it[prefKey] = value
        }
    }

    override suspend fun getString(key: String): String? {
        return try {
            val prefKey = stringPreferencesKey(key)
            val preference = context.dataStore.data.first()
            preference[prefKey]
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun clearPreference(key: String) {
        val prefKey = stringPreferencesKey(key)
        context.dataStore.edit {
            if (it.contains(prefKey)) {
                it.remove(prefKey)
            }
        }
    }
}
