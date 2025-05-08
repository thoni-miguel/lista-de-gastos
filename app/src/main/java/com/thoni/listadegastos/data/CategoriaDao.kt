package com.thoni.listadegastos.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thoni.listadegastos.model.Categoria
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoriaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(categoria: Categoria)

    @Query("SELECT * FROM categorias ORDER BY nome ASC")
    fun listarTodas(): Flow<List<Categoria>>
}