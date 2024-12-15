package pe.idat.quickpool.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cliente")
data class ClienteEntity(
    @PrimaryKey
    val id: Int,
    val nombres: String,
    val apellidos: String,
    val email: String,
    val celular: String,
    val usuario: String,
    val password: String,
)
