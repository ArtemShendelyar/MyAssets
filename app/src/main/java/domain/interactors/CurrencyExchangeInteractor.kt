package domain.interactors

import domain.repository.CurrencyExchangeRateRepository
import javax.inject.Inject

class CurrencyExchangeInteractor @Inject constructor(
    private val exchangeRateRepository: CurrencyExchangeRateRepository
) {
    suspend fun convertCurrency(amount: Double, fromCurrency: String, toCurrency: String): Double {
        val fromExchangeRate = exchangeRateRepository.getExchangeRate(fromCurrency)
        val toExchangeRate = exchangeRateRepository.getExchangeRate(toCurrency)
        return amount * (fromExchangeRate.rate / toExchangeRate.rate) *
                        (toExchangeRate.scale / fromExchangeRate.scale)
    }
}
