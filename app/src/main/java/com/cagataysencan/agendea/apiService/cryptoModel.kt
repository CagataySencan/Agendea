package com.cagataysencan.agendea.apiService


import com.google.gson.annotations.SerializedName

 data class cryptoModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("logo_url")
    val logoUrl: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("price_date")
    val priceDate: String,
    @SerializedName("price_timestamp")
    val priceTimestamp: String,
    @SerializedName("circulating_supply")
    val circulatingSupply: String,
    @SerializedName("max_supply")
    val maxSupply: String,
    @SerializedName("market_cap")
    val marketCap: String,
    @SerializedName("market_cap_dominance")
    val marketCapDominance: String,
    @SerializedName("num_exchanges")
    val numExchanges: String,
    @SerializedName("num_pairs")
    val numPairs: String,
    @SerializedName("num_pairs_unmapped")
    val numPairsUnmapped: String,
    @SerializedName("first_candle")
    val firstCandle: String,
    @SerializedName("first_trade")
    val firstTrade: String,
    @SerializedName("first_order_book")
    val firstOrderBook: String,
    @SerializedName("rank")
    val rank: String,
    @SerializedName("rank_delta")
    val rankDelta: String,
    @SerializedName("high")
    val high: String,
    @SerializedName("high_timestamp")
    val highTimestamp: String,
    @SerializedName("1d")
    val d: D
 )