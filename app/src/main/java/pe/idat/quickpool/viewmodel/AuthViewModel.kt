package pe.idat.quickpool.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pe.idat.quickpool.repository.AuthRepository
import pe.idat.quickpool.retrofit.request.RequestLogin
import pe.idat.quickpool.retrofit.request.RequestRegistro
import pe.idat.quickpool.retrofit.response.ResponseLogin
import pe.idat.quickpool.retrofit.response.ResponseRegistro

class AuthViewModel: ViewModel() {
    var responseLogin: LiveData<ResponseLogin>
    var responseRegistro: LiveData<ResponseRegistro>
    private var repository = AuthRepository()
    init {
        responseLogin = repository.loginResponse
        responseRegistro = repository.registroResponse
    }
    fun autenticarUsuario(username: String, password: String){
        responseLogin = repository.autenticarUsuario(RequestLogin(username, password))
    }
    fun registrarUsuario(nombre: String, apellido: String,
                         email: String, celular: String,
                         username: String, password: String){
        responseRegistro = repository.registrarUsuario(
            RequestRegistro(nombre, apellido, email, celular,
                username, password)
        )
    }
}