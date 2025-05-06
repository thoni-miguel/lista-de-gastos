package com.thoni.listadegastos.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thoni.listadegastos.data.GastoDao
import com.thoni.listadegastos.model.Gasto
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class GastoViewModel(private val dao: GastoDao) : ViewModel() {

    val listaDeGastos: StateFlow<List<Gasto>> = dao.getTodos()
        .map { it.sortedByDescending { gasto -> gasto.id } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun adicionarGasto(gasto: Gasto) {
        viewModelScope.launch {
            dao.inserir(gasto)
        }
    }

    fun deletarGasto(gasto: Gasto) {
        viewModelScope.launch {
            dao.deletar(gasto)
        }
    }

    fun atualizarGasto(gasto: Gasto) {
        viewModelScope.launch {
            dao.atualizar(gasto)
        }
    }
}