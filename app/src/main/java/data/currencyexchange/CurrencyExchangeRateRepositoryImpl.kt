package data.currencyexchange

import domain.entity.CurrencyExchangeRate
import domain.repository.CurrencyExchangeRateRepository
import javax.inject.Inject

class CurrencyExchangeRateRepositoryImpl @Inject constructor(
    private val exchangeRateApi: CurrencyExchangeRateApi
) : CurrencyExchangeRateRepository {
    override suspend fun getExchangeRate(requestedCurrency: String): CurrencyExchangeRate {
        return exchangeRateApi.getExchangeRate(requestedCurrency)
    }
}
