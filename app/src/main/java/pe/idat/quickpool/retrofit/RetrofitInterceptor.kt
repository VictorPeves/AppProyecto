package pe.idat.quickpool.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class RetrofitInterceptor :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
            val token = ""
            val request = chain.request().newBuilder()
                .addHeader(
                    "Authorization",
                    "Bearer "+token).build()
            return chain.proceed(request)
    }
}