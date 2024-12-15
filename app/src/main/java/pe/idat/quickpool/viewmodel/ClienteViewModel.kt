package pe.idat.quickpool.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.idat.quickpool.db.RapidinRoomDataBase
import pe.idat.quickpool.db.entity.ClienteEntity
import pe.idat.quickpool.repository.ClienteRepository

class ClienteViewModel(application: Application) : AndroidViewModel(application){

    private val repository: ClienteRepository
    init {
        val clienteDao = RapidinRoomDataBase.getDatabase(application).clienteDao()
        repository = ClienteRepository(clienteDao)
    }

    fun insertar(clienteEntity: ClienteEntity) =
        viewModelScope.launch(Dispatchers.IO){
            repository.insertar(clienteEntity)
        }
    fun actualizar(clienteEntity: ClienteEntity) =
        viewModelScope.launch(Dispatchers.IO){
            repository.actualizar(clienteEntity)
        }
    fun eliminartodo() = viewModelScope.launch(Dispatchers.IO){
        repository.eliminartodo()
    }
    fun obtener() : LiveData<ClienteEntity>{
        return repository.obtener()
    }
}