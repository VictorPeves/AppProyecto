package pe.idat.quickpool.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object QuickPoolCliente {

    private var okHttpClient = OkHttpClient.Builder()
        .addInterceptor(RetrofitInterceptor())
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .build()

    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl("http://localhost:8080/quickpool")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofitService: QuickPoolService by lazy {
        buildRetrofit().create(QuickPoolService::class.java)
    }
}