package com.thoni.listadegastos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.thoni.listadegastos.data.AppDatabase
import com.thoni.listadegastos.ui.GastoViewModel
import com.thoni.listadegastos.ui.GastoViewModelFactory
import com.thoni.listadegastos.ui.screens.MainScreen
import com.thoni.listadegastos.ui.theme.ListaDeGastosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaDeGastosTheme {
                val dao = AppDatabase.getDatabase(applicationContext).gastoDao()
                val viewModel: GastoViewModel = viewModel(factory = GastoViewModelFactory(dao))
                MainScreen(viewModel = viewModel)
            }
        }
    }
}