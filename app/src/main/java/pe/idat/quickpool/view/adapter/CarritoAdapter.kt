package pe.idat.quickpool.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.idat.quickpool.R
import pe.idat.quickpool.databinding.ItemCarritoBinding
import pe.idat.quickpool.databinding.ItemPlatoBinding
import pe.idat.quickpool.retrofit.response.ResponsePlato

class CarritoAdapter (var tvtotalcompras: TextView, var carritocompras: ArrayList<ResponsePlato>): RecyclerView.Adapter<CarritoAdapter.ViewHolder>(){

    var total: Double = 0.0

    inner class ViewHolder (val binding: ItemCarritoBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoAdapter.ViewHolder {
        val binding = ItemCarritoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        total = 0.0
        carritocompras.forEach { total += it.precio }
        tvtotalcompras.text = "$$total"

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarritoAdapter.ViewHolder, position: Int) {
        with(holder){
            with(carritocompras[position]){
                binding.tvnomplatocarrito.text = nombre
                binding.tvdesplatocarrito.text = descripcion
                binding.tvcantidadcarrito.text = cantidad.toString()
                binding.tvprecioplatocarrito.text= precio.toString()
                com.bumptech.glide.Glide.with(holder.itemView.context)
                    .load(url)
                    .into(binding.ivcarrito)
            }
        }
    }

    override fun getItemCount(): Int = carritocompras.size

}