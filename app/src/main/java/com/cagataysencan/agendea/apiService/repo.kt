package com.cagataysencan.agendea.apiService

import retrofit2.Response

class repo {
    suspend fun getCryptos() : Response<ArrayList<cryptoModel>> {
     return   retrofitInstance.api.getCrypto()

    }
}