package pe.idat.quickpool.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object QuickPoolCliente {
    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl("http://localhost:8080/quickpool")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofitService: QuickPoolService by lazy {
        buildRetrofit().create(QuickPoolService::class.java)
    }
}