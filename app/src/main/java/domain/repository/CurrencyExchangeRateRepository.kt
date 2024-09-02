package domain.repository

import domain.entity.CurrencyExchangeRate

interface CurrencyExchangeRateRepository {
    suspend fun getExchangeRate(requestedCurrency: String): CurrencyExchangeRate
}
