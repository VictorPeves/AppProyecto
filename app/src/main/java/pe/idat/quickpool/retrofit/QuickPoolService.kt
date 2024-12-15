package pe.idat.quickpool.retrofit

import pe.idat.quickpool.retrofit.request.RequestLogin
import pe.idat.quickpool.retrofit.request.RequestRegistro
import pe.idat.quickpool.retrofit.response.ResponseLogin
import pe.idat.quickpool.retrofit.response.ResponseRegistro
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface QuickPoolService {
    @POST("login")
    fun login(@Body loginRequest: RequestLogin):
            Call<ResponseLogin>
    @POST("guardarusuario")
    fun registro(@Body requestRegistro: RequestRegistro):
            Call<ResponseRegistro>
}