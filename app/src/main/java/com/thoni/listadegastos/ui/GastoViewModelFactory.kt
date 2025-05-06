package com.thoni.listadegastos.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thoni.listadegastos.data.GastoDao

class GastoViewModelFactory(private val dao: GastoDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GastoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GastoViewModel(dao) as T
        }
        throw IllegalArgumentException("ViewModel desconhecida")
    }
}