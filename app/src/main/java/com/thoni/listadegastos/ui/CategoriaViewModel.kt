package com.thoni.listadegastos.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.thoni.listadegastos.model.Categoria
import com.thoni.listadegastos.data.CategoriaDao
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CategoriaViewModel(private val dao: CategoriaDao) : ViewModel() {

    val categorias: StateFlow<List<Categoria>> = dao.listarTodas().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun inserirCategoria(categoria: Categoria) {
        viewModelScope.launch {
            dao.inserir(categoria)
        }
    }
}

class CategoriaViewModelFactory(private val dao: CategoriaDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoriaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return CategoriaViewModel(dao) as T
        }
        throw IllegalArgumentException("ViewModel desconhecida")
    }
}