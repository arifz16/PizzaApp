package com.example.pizzaapp

import android.graphics.Bitmap
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.model.MenuModel

class MakananAdapter(private val list: ArrayList<MenuModel>) :
    RecyclerView.Adapter<MakananAdapter.MakananViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MakananAdapter.MakananViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MakananAdapter.MakananViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class MakananViewHolder(v: View):RecyclerView.ViewHolder(v) {
        val textId : TextView
        val textNama : TextView
        val textHarga : TextView
        val imageMenu : ImageView

        init {
            textId = v.findViewById(R.id.textIdMakanan)
            textNama = v.findViewById(R.id.textNamaMakanan)
            textHarga = v.findViewById(R.id.textHargaMakanan)
            imageMenu = v.findViewById(R.id.imageMakanan)
        }

        fun bind(data: MenuModel){
            val id:Int = data.id
            val nama:String = data.name
            val harga:Int = data.price
            val gambar:Bitmap = data.image

            textId.text = id.toString()
            textNama.text = nama
            textHarga.text = harga.toString()
            imageMenu.setImageBitmap(gambar)
        }
    }

}