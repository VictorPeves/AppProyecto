package pe.idat.quickpool.retrofit.response

data class ResponsePedido(
    val id: Int,
    var nombre: String,
    var descripcion: String,
    var precio: Double,
    var cantidad: Int = 1,
    var url: String
)
