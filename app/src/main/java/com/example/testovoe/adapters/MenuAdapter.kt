package com.example.testovoe.adapters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testovoe.R
import com.example.testovoe.models.MenuList

class MenuAdapter : RecyclerView.Adapter<MenuAdapter.MenuAdapterViewHolder>() {

    private var menu : List<MenuList> = listOf()
    var itemName = MutableLiveData<String>()
    var itemID = MutableLiveData<String>()
    class MenuAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val image : ImageView = view.findViewById(R.id.menu_image)
        private val name : TextView = view.findViewById(R.id.menu_name)
        fun bind (menuItem : MenuList){
            Glide.with(itemView).load(menuItem.image).into(image)
            name.text = menuItem.name
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuAdapter.MenuAdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_item, parent, false)
        return MenuAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuAdapterViewHolder, position: Int) {
        holder.bind(menu[position])
        holder.itemView.setOnClickListener {
            itemName.value = menu[position].name.toString()
            itemID.value = menu[position].menuID.toString()
        }
    }

    override fun getItemCount(): Int {
        return menu.size
    }

    fun setMenu(menu : List<MenuList>){
        this.menu = menu
        notifyDataSetChanged()
    }
}