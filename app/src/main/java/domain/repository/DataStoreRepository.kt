package domain.repository

interface DataStoreRepository {
    suspend fun setDefaultCurrency(value: String)
    suspend fun getDefaultCurrency(): String?
}
