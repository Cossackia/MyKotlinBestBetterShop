package com.soloviev.mykotlinbestbettershop

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterWithTools(var tools: List<Items>, var context: Context) : RecyclerView.Adapter<AdapterWithTools.MyViewHolder>() {

    // вложенный класс
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.item_with_image)
        val title: TextView = view.findViewById(R.id.item_with_list_title)
        val desc: TextView = view.findViewById(R.id.item_with_list_desc)
        val price: TextView = view.findViewById(R.id.item_with_list_price)
        val btn: Button = view.findViewById(R.id.item_with_list_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewAll = LayoutInflater.from(parent.context).inflate(R.layout.tools_in_items, parent, false)
        return MyViewHolder(viewAll)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = tools[position].title
        holder.desc.text = tools[position].desc
        holder.price.text = tools[position].price.toString() + "₽"

        val imageId = context.resources.getIdentifier(
            tools[position].image,
            "drawable",
            context.packageName
        )

        holder.image.setImageResource(imageId)

        holder.btn.setOnClickListener {
            val intent = Intent(context, ProductDescription::class.java)

            intent.putExtra("itemTitle", tools[position].title)
            intent.putExtra("itemText", tools[position].text)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return tools.count()
    }


}