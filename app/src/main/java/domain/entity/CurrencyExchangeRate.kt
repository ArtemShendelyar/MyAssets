package domain.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyExchangeRate(
    @SerialName("Cur_ID")
    val id: Int = 0,

    @SerialName("Date")
    val date: String = "",

    @SerialName("Cur_Abbreviation")
    val abbreviation: String = "",

    @SerialName("Cur_Scale")
    val scale: Int = 0,

    @SerialName("Cur_Name")
    val name: String = "",

    @SerialName("Cur_OfficialRate")
    val rate: Double = 0.0
)
