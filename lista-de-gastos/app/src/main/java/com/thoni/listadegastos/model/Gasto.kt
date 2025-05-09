package com.thoni.listadegastos.model
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gastos")
data class Gasto (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // Id único do Gasto, será gerado pelo BD
    val titulo: String,
    val valor: Double,
    val categoria: String,
    val descricao: String? = null // Descrição opcional
)