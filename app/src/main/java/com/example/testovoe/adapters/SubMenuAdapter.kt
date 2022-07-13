package com.example.testovoe.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testovoe.R
import com.example.testovoe.models.MenuList

class SubMenuAdapter : RecyclerView.Adapter<SubMenuAdapter.SubMenuViewHolder>() {

    private var subMenu : List<MenuList> = listOf()

    class SubMenuViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val image : ImageView = view.findViewById(R.id.subMenu_image)
        private val name : TextView = view.findViewById(R.id.subMenu_name)
//        private val content
//        private val price
//        private val weigth
//        private val spicy
        fun bind (subMenuItem : MenuList){
            Glide.with(itemView).load(subMenuItem.image).into(image)
            name.text = subMenuItem.name
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
    fun setSubMenu(subMenu: List<MenuList>){
        this.subMenu = subMenu
        notifyDataSetChanged()
    }
}