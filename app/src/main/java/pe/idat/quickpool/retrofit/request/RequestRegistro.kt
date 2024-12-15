package pe.idat.quickpool.retrofit.request

data class RequestRegistro(
    var nombre: String,
    var apellido: String,
    var email: String,
    var username: String,
    var password: String,
    var celular: String
)
