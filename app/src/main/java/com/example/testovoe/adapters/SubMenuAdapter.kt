package com.example.testovoe.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.SubMenu
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testovoe.R
import com.example.testovoe.models.MenuList
import com.example.testovoe.models.SubMenuList

class SubMenuAdapter : RecyclerView.Adapter<SubMenuAdapter.SubMenuViewHolder>() {

    private var subMenu : List<SubMenuList> = listOf()

    class SubMenuViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val image : ImageView = view.findViewById(R.id.subMenu_image)
        private val name : TextView = view.findViewById(R.id.subMenu_name)
        private val content : TextView = view.findViewById(R.id.subMenu_contains)
        private val price : TextView = view.findViewById(R.id.price)
        private val weight : TextView = view.findViewById(R.id.weight)
        private val spicy : ImageView = view.findViewById(R.id.spicy)
        fun bind (subMenuItem : SubMenuList){
            if (subMenuItem.spicy == "Y"){
                spicy.setImageResource(R.drawable.chili_pepper)
            }
            val imagesrc = "https://vkus-sovet.ru/" + subMenuItem.image
            Glide.with(itemView).load(imagesrc).into(image)
            var pricestr = subMenuItem.price
            pricestr?.replaceAfter(".", " ")
            name.text = subMenuItem.name
            content.text = subMenuItem.content
            price.text = pricestr + "₽"
            weight.text = subMenuItem.weight
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubMenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.submenu_item, parent, false)
        return SubMenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubMenuViewHolder, position: Int) {
        holder.bind(subMenu[position])

    }

    override fun getItemCount(): Int {
        return subMenu.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setSubMenu(subMenu: List<SubMenuList>){
        this.subMenu = subMenu
        notifyDataSetChanged()
    }
}