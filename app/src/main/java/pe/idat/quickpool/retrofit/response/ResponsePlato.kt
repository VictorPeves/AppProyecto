package pe.idat.quickpool.retrofit.response

import java.io.Serializable

data class ResponsePlato(
    var nombre: String,
    var descripcion: String,
    var precio: Double,
    var cantidad: Int = 1,
    var url: String
): Serializable