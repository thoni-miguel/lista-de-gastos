package com.thoni.listadegastos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.thoni.listadegastos.data.AppDatabase
import com.thoni.listadegastos.ui.CategoriaViewModel
import com.thoni.listadegastos.ui.CategoriaViewModelFactory
import com.thoni.listadegastos.ui.theme.ListaDeGastosTheme
import com.thoni.listadegastos.ui.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaDeGastosTheme {
                val dao = AppDatabase.getDatabase(applicationContext).categoriaDao()
                val viewModel: CategoriaViewModel = viewModel(factory = CategoriaViewModelFactory(dao))
                val navController = rememberNavController()
                AppNavHost(navController = navController, viewModel = viewModel)
            }
        }
    }
}