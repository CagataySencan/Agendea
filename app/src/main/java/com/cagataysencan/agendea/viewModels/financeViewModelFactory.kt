package com.cagataysencan.agendea.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cagataysencan.agendea.apiService.repo

@Suppress("UNCHECKED_CAST")
class financeViewModelFactory(private val repos : repo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return financeViewModel(repos) as T
    }


}