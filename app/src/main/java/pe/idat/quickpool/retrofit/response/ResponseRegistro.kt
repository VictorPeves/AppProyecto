package pe.idat.quickpool.retrofit.response

data class ResponseRegistro(
    var idCliente: Int,
    var nombre: String,
    var apellido: String,
    var email: String,
    var username: String,
    var password: String,
    var celular: String,
    var activo: Boolean
)
