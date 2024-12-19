package pe.idat.quickpool.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import pe.idat.quickpool.retrofit.QuickPoolCliente
import pe.idat.quickpool.retrofit.request.RequestLogin
import pe.idat.quickpool.retrofit.request.RequestRegistro
import pe.idat.quickpool.retrofit.response.ResponseLogin
import pe.idat.quickpool.retrofit.response.ResponseRegistro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository {
    var loginResponse = MutableLiveData<ResponseLogin>()
    var registroResponse = MutableLiveData<ResponseRegistro>()

    fun autenticarUsuario(requestLogin: RequestLogin): MutableLiveData<ResponseLogin>{
        val call: Call<ResponseLogin> = QuickPoolCliente.retrofitService.login(requestLogin)
        call.enqueue(object : Callback<ResponseLogin>{
            override fun onResponse(p0: Call<ResponseLogin>, p1: Response<ResponseLogin>) {
                loginResponse.value = p1.body()
            }

            override fun onFailure(p0: Call<ResponseLogin>, p1: Throwable) {
                Log.e("ErrorAPILogin",
                    p1.message.toString())
            }
        })
        return loginResponse
    }
    fun registrarUsuario(requestRegistro: RequestRegistro): MutableLiveData<ResponseRegistro>{
        val call: Call<ResponseRegistro> = QuickPoolCliente.retrofitService.registro(requestRegistro)
        call.enqueue(object : Callback<ResponseRegistro> {
            override fun onResponse(p0: Call<ResponseRegistro>, p1: Response<ResponseRegistro>) {
                registroResponse.value = p1.body()
               // Log.i("INFO-API", p1.body().toString())
            }

            override fun onFailure(p0: Call<ResponseRegistro>, p1: Throwable) {
                Log.e("ErrorAPIResgistro",
                    p1.message.toString())
            }

        })
        return  registroResponse
    }
}