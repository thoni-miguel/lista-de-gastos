package com.thoni.listadegastos.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.thoni.listadegastos.data.ItemDao
import com.thoni.listadegastos.model.Item
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ItemViewModel(private val dao: ItemDao): ViewModel() {

    val items: StateFlow<List<Item>> = dao.listAll().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
        initialValue = emptyList()
    )

    fun insertItem(item: Item) {
        viewModelScope.launch {
            dao.insert(item)
        }
    }
}

class ItemViewModelFactory(private val dao: ItemDao): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemViewModel::class.java)) {
            @Suppress("UNCHECKED CAST") return ItemViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown Viewmodel")
    }
}