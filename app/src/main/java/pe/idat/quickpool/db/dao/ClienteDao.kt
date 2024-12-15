package pe.idat.quickpool.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import pe.idat.quickpool.db.entity.ClienteEntity

@Dao
interface ClienteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertar(vararg cliente: ClienteEntity)
    @Update
    fun actualizar(vararg cliente: ClienteEntity)
    @Query("DELETE FROM cliente")
    fun eliminarTodo()
    @Query("SELECT * FROM cliente LIMIT 1")
    fun obtener(): LiveData<ClienteEntity>
}