package com.cagataysencan.agendea.viewModels

import androidx.lifecycle.*
import com.cagataysencan.agendea.apiService.repo
import com.cagataysencan.agendea.apiService.cryptoModel
import kotlinx.coroutines.launch
import retrofit2.Response

class financeViewModel( private val repo : repo) : ViewModel() {
   val myResponse : MutableLiveData<Response<ArrayList<cryptoModel>>> = MutableLiveData()

    fun getCrypto() {
        viewModelScope.launch {
            val response = repo.getCryptos()
            myResponse.value = response
        }
    }

}