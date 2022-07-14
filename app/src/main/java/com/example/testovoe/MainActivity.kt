package com.example.testovoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.testovoe.adapters.MenuAdapter
import com.example.testovoe.adapters.SubMenuAdapter
import com.example.testovoe.viewmodels.RequestsViewModel

class MainActivity : AppCompatActivity() {

    private var subMenuAdapter = SubMenuAdapter()
    private var menuAdapter = MenuAdapter()
    private lateinit var recyclerViewSubMenu: RecyclerView
    private lateinit var recyclerViewMenu: RecyclerView
    private val viewModel : RequestsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getMenu()

        var menuCategory : TextView = findViewById(R.id.category_name)
        recyclerViewSubMenu = findViewById(R.id.subMenu_RV)
        recyclerViewMenu = findViewById(R.id.menu_RV)
        viewModel.exception.observe(this){
            if (it==1){
                val intent = Intent(this@MainActivity, ErrorActivity::class.java)
                startActivity(intent)
            }
        }
        viewModel.subMenuList.observe(this){
            if (it.status == "true"){
                subMenuAdapter.setSubMenu(it.menuList)
            }
        }
        viewModel.menuList.observe(this){
            if (it.status == "true"){
                menuAdapter.setMenu(it.menuList)
            }
        }
        recyclerViewSubMenu.adapter = subMenuAdapter
        recyclerViewMenu.adapter = menuAdapter
        menuAdapter.itemName.observe(this){ categoryName->
            menuCategory.text = categoryName
        }
        menuAdapter.itemID.observe(this){ id ->
            viewModel.getSubMenu(id)
        }
    }

}