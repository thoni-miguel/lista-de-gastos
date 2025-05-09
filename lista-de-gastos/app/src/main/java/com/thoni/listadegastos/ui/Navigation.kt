package com.thoni.listadegastos.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thoni.listadegastos.ui.screens.CategoriaScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    viewModel: CategoriaViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "categorias",
        modifier = modifier
    ) {
        composable("categorias") {
            CategoriaScreen(viewModel = viewModel)
        }
    }
}