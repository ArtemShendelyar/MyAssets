package data.currencyexchange

import domain.entity.CurrencyExchangeRate
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyExchangeRateApi {
    @GET("/exrates/rates/{requestedCurrency}?parammode=2")
    suspend fun getExchangeRate(@Path("requestedCurrency") requestedCurrency: String):
            CurrencyExchangeRate
}
