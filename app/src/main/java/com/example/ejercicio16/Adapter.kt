package com.example.ejercicio16


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ejercicio16.databinding.ItemLayoutBinding


class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var paises = mutableListOf<Pais>()
    var callBack: PaisCallBack? = null

    fun setPaisCallBack(c: PaisCallBack) {
        this.callBack = c
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = paises[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return paises.size

    }

    fun setData(listaPaises: List<Pais>) {
        this.paises = listaPaises.toMutableList()
    }

    inner class ViewHolder(var binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(item: Pais) {
            binding.textView2.text = item.nombre
            binding.imageView.load(item.imgUrl)
            binding.cardView.setOnClickListener {
                val texto = "Pais:${item.nombre} Poblacion:${item.poblacion}"
                callBack?.showCountrie(texto)
            }
        }
    }

    interface PaisCallBack {
        fun showCountrie(s: String)


    }
}