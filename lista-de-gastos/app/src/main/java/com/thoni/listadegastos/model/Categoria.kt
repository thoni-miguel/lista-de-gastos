package com.thoni.listadegastos.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categorias")
data class Categoria (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val descricao: String? = null,
    val cor: Int? = null // Formato ARGB, mas pode ser nulo
)