package com.thoni.listadegastos.data

import androidx.room.*
import com.thoni.listadegastos.model.Gasto
import kotlinx.coroutines.flow.Flow

@Dao
interface GastoDao {
    @Query("SELECT * FROM gastos ORDER BY id DESC")
    fun getTodos(): Flow<List<Gasto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(gasto: Gasto)

    @Update
    suspend fun atualizar(gasto: Gasto)

    @Delete
    suspend fun deletar(gasto: Gasto)

    @Query("SELECT * FROM gastos WHERE id = :id")
    suspend fun getPorId(id: Int): Gasto?
}