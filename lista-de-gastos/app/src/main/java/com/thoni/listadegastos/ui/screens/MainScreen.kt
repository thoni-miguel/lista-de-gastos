package com.thoni.listadegastos.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thoni.listadegastos.model.Gasto
import com.thoni.listadegastos.ui.GastoViewModel

@Composable
fun MainScreen(viewModel: GastoViewModel) {
    var titulo by remember { mutableStateOf("") }
    var valor by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }

    val lista by viewModel.listaDeGastos.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        // Campos de entrada
        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = valor,
            onValueChange = { valor = it },
            label = { Text("Valor") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = categoria,
            onValueChange = { categoria = it },
            label = { Text("Categoria") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                if (titulo.isNotBlank() && valor.isNotBlank()) {
                    viewModel.adicionarGasto(
                        Gasto(
                            titulo = titulo,
                            valor = valor.toDoubleOrNull() ?: 0.0,
                            categoria = categoria
                        )
                    )
                    titulo = ""
                    valor = ""
                    categoria = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Adicionar Gasto")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Lista de gastos
        LazyColumn {
            items(lista) { gasto ->
                Text("• ${gasto.titulo} - R$ ${gasto.valor} [${gasto.categoria}]")
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}