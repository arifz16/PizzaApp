package com.example.pizzaapp

import android.content.Intent
import android.graphics.Bitmap
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toBitmap
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
        val buttonEdit : Button
         val buttonDelete: Button
        val context = v.context


        init {
            textId = v.findViewById(R.id.textIdMakanan)
            textNama = v.findViewById(R.id.textNamaMakanan)
            textHarga = v.findViewById(R.id.textHargaMakanan)
            imageMenu = v.findViewById(R.id.imageMakanan)
            buttonEdit = v.findViewById(R.id.buttonEditMakanan)
            buttonDelete = v.findViewById(R.id.buttonHapusMakanan)
            //
            buttonDelete.setOnClickListener {
                val dbHelper = DatabaseHelper(context)
                dbHelper.deleteMenu(textId.text.toString().toInt())
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            }
            //event saat button
            buttonEdit.setOnClickListener {
                EditMenuActivity.idMakanan = textId.text.toString().toInt()
                EditMenuActivity.namaMakanan = textNama.text.toString()
                EditMenuActivity.hargaMakanan = textHarga.text.toString().toInt()
                EditMenuActivity.gambarMakanan = imageMenu.drawable.toBitmap(150,150,null)

                val intent = Intent(context, EditMenuActivity::class.java)
                context.startActivity(intent)
            }
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