package pe.idat.quickpool.view.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import pe.idat.quickpool.R
import pe.idat.quickpool.databinding.ActivityCarritoBinding
import pe.idat.quickpool.retrofit.response.ResponsePlato
import pe.idat.quickpool.view.adapter.CarritoAdapter
import pe.idat.quickpool.view.adapter.PlatoAdapter

class CarritoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarritoBinding
    private lateinit var adapter: CarritoAdapter

    var carritoCompras = ArrayList<ResponsePlato>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carritoCompras = intent.getSerializableExtra("carrito_compras") as ArrayList<ResponsePlato>
        setupReyclerView()
    }

    private fun setupReyclerView() {
        binding.rvlistacarritos.layoutManager = LinearLayoutManager(this)
        adapter = CarritoAdapter(binding.tvtotallistacarritos, carritoCompras)
        binding.rvlistacarritos.adapter = adapter
    }
}