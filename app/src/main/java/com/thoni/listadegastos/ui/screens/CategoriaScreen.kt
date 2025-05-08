package com.thoni.listadegastos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.thoni.listadegastos.model.Categoria
import com.thoni.listadegastos.ui.CategoriaViewModel

@Composable
fun CategoriaScreen(viewModel: CategoriaViewModel) {
    // Estado de controle do diálogo
    var showDialog by remember { mutableStateOf(false) }

    // Observa categorias do banco
    val categorias by viewModel.categorias.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Text("+")
            }
        }
    ) { padding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)) {

            Text("Categorias", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(categorias) { categoria ->
                    CategoriaItem(categoria)
                }
            }
        }
    }

    if (showDialog) {
        CategoriaDialog(
            onDismiss = { showDialog = false },
            onSalvar = { novaCategoria ->
                viewModel.inserirCategoria(novaCategoria)
                showDialog = false
            }
        )
    }
}

@Composable
fun CategoriaItem(categoria: Categoria) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = categoria.cor?.let { Color(it) } ?: MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(categoria.nome, style = MaterialTheme.typography.titleMedium)
            if (!categoria.descricao.isNullOrBlank()) {
                Text(categoria.descricao!!, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}


@Composable
fun CategoriaDialog(
    onDismiss: () -> Unit,
    onSalvar: (Categoria) -> Unit
) {
    val coresDisponiveis = listOf(
        0xFF2196F3.toInt(), // Azul
        0xFF4CAF50.toInt(), // Verde
        0xFFFFEB3B.toInt(), // Amarelo
        0xFFF44336.toInt(), // Vermelho
        0xFF9C27B0.toInt()  // Roxo
    )

    var nome by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var corSelecionada by remember { mutableStateOf<Int?>(null) }
    var erroNome by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Nova Categoria") },
        text = {
            Column {
                OutlinedTextField(
                    value = nome,
                    onValueChange = {
                        nome = it
                        erroNome = false
                    },
                    label = { Text("Nome") },
                    isError = erroNome,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = descricao,
                    onValueChange = { descricao = it },
                    label = { Text("Descrição (opcional)") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text("Cor (opcional):")
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    coresDisponiveis.forEach { cor ->
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .background(Color(cor))
                                .clickable { corSelecionada = cor }
                                .then(
                                    if (corSelecionada == cor) Modifier.border(2.dp, Color.Black)
                                    else Modifier
                                )
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = {
                if (nome.isBlank()) {
                    erroNome = true
                    return@TextButton
                }
                val novaCategoria = Categoria(
                    nome = nome.trim(),
                    descricao = descricao.trim().ifBlank { null },
                    cor = corSelecionada
                )
                onSalvar(novaCategoria)
            }) {
                Text("Salvar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}