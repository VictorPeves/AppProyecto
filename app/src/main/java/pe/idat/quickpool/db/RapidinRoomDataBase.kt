package pe.idat.quickpool.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pe.idat.quickpool.db.dao.ClienteDao
import pe.idat.quickpool.db.entity.ClienteEntity

@Database(entities = [ClienteEntity::class], version = 1)
abstract class RapidinRoomDataBase : RoomDatabase() {

    abstract fun clienteDao(): ClienteDao

    companion object {
        @Volatile
        private var INSTANCIA : RapidinRoomDataBase? = null

        fun getDatabase(context: Context): RapidinRoomDataBase{
            val tempInstancia = INSTANCIA
            if (tempInstancia != null){
                return tempInstancia
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    RapidinRoomDataBase::class.java, "rapidindb").build()
                INSTANCIA = instance
                return instance
            }
        }
    }
}