package pe.idat.quickpool.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.idat.quickpool.databinding.ItemPlatoBinding
import pe.idat.quickpool.retrofit.response.ResponsePlato

class PlatoAdapter(
    private var listaPlato: List<ResponsePlato>)
    : RecyclerView.Adapter<PlatoAdapter.ViewHolder>()
{
    inner class ViewHolder(val binding: ItemPlatoBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatoAdapter.ViewHolder {
        val binding = ItemPlatoBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listaPlato.size

    override fun onBindViewHolder(holder: PlatoAdapter.ViewHolder, position: Int) {
        with(holder){
            with(listaPlato[position]){
                binding.tvnomplato.text = nombre
                binding.tvdesplato.text = descripcion
                binding.tvprecplato.text= precio.toString()
                Glide.with(holder.itemView.context)
                    .load(url)
                    .into(binding.ivplato)
            }
        }
    }
}