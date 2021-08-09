package com.cagataysencan.agendea.apiService


import com.google.gson.annotations.SerializedName

data class D(
    @SerializedName("volume")
    val volume: String,
    @SerializedName("price_change")
    val priceChange: String,
    @SerializedName("price_change_pct")
    val priceChangePct: String,
    @SerializedName("volume_change")
    val volumeChange: String,
    @SerializedName("volume_change_pct")
    val volumeChangePct: String,
    @SerializedName("market_cap_change")
    val marketCapChange: String,
    @SerializedName("market_cap_change_pct")
    val marketCapChangePct: String
)