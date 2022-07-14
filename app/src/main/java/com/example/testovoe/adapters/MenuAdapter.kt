package com.example.testovoe.adapters

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
import com.makeramen.roundedimageview.RoundedImageView

class MenuAdapter : RecyclerView.Adapter<MenuAdapter.MenuAdapterViewHolder>() {

    private var menu : List<MenuList> = listOf()
    var itemName = MutableLiveData<String>()
    var itemID = MutableLiveData<String>()
    class MenuAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val image : ImageView = view.findViewById(R.id.menu_image)
        private val name : TextView = view.findViewById(R.id.menu_name)
        private val subMenuCount : TextView = view.findViewById(R.id.subMenuCount)
        var color : RoundedImageView = view.findViewById(R.id.roundedImageView)
        fun bind (menuItem : MenuList){
            val imagesrc = "https://vkus-sovet.ru/" + menuItem.image
            Glide.with(itemView).load(imagesrc).into(image)
            name.text = menuItem.name
            subMenuCount.text = menuItem.subMenuCount + " товаров"
            color.setImageResource(R.color.mid_gray)
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):MenuAdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_item, parent, false)
        return MenuAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuAdapterViewHolder, position: Int) {
        holder.bind(menu[position])
        holder.itemView.setOnClickListener {
            itemName.value = menu[position].name.toString()
            itemID.value = menu[position].menuID.toString()
            holder.color.setImageResource(R.color.mid_gray)
            val color2 : RoundedImageView = it.findViewById(R.id.roundedImageView)
            color2.setImageResource(R.color.blue)
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