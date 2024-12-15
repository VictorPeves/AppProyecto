package pe.idat.quickpool.repository

import androidx.lifecycle.LiveData
import pe.idat.quickpool.db.dao.ClienteDao
import pe.idat.quickpool.db.entity.ClienteEntity

class ClienteRepository (private val clienteDao: ClienteDao){

    suspend fun insertar(clienteEntity: ClienteEntity){
        clienteDao.insertar(clienteEntity)
    }
    suspend fun actualizar(clienteEntity: ClienteEntity){
        clienteDao.actualizar(clienteEntity)
    }
    suspend fun eliminartodo(){
        clienteDao.eliminarTodo()
    }
    fun obtener(): LiveData<ClienteEntity>{
        return clienteDao.obtener()
    }
}