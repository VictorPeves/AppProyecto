package pe.idat.quickpool.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.idat.quickpool.databinding.ItemRestauranteBinding
import pe.idat.quickpool.retrofit.response.ResponseRestaurante

class RestauranteAdapter(private var listaRestaurante: List<ResponseRestaurante>):
RecyclerView.Adapter<RestauranteAdapter.ViewHolder>(){
    inner class ViewHolder(val binding: ItemRestauranteBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteAdapter.ViewHolder {
        val binding = ItemRestauranteBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listaRestaurante.size

    override fun onBindViewHolder(holder: RestauranteAdapter.ViewHolder, position: Int) {
        with(holder){
            with(listaRestaurante[position]){
                binding.tvnomrestaurente.text = nombre
                binding.tvdesrestaurante.text = descripcion
                binding.tvubirestaurante.text = ubicacion
                Glide.with(holder.itemView.context)
                    .load(url)
                    .into(binding.ivrestaurante)
            }
        }
    }
}