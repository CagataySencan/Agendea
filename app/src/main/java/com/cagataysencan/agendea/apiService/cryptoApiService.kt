package com.cagataysencan.agendea.apiService

import retrofit2.http.GET

const val API_KEY = "e99eabe9619ac3e36b366ca16a9d61a1571885c7"
//https://api.nomics.com/v1/currencies/ticker?key=e99eabe9619ac3e36b366ca16a9d61a1571885c7&interval=1d&per-page=10
interface cryptoApiService {

    @GET("currencies/ticker?key=e99eabe9619ac3e36b366ca16a9d61a1571885c7&interval=1d&per-page=100")
  suspend fun getCrypto(
    ) : retrofit2.Response<ArrayList<cryptoModel>>





}