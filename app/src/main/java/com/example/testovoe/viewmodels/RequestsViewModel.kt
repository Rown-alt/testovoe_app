package com.example.testovoe.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testovoe.api.RetrofitInstance
import com.example.testovoe.models.MenuList
import com.example.testovoe.models.MenuRequest
import com.example.testovoe.models.SubMenuRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RequestsViewModel : ViewModel(){

    var subMenuList = MutableLiveData<SubMenuRequest>()
    var menuList = MutableLiveData<List<MenuList>>()
    fun getMenu(){
        viewModelScope.launch(Dispatchers.IO) {
                menuList.postValue(RetrofitInstance.api.getCategories().menuList)
        }
    }
    fun getSubMenu(id : String){
        viewModelScope.launch(Dispatchers.IO) {
            subMenuList.postValue(RetrofitInstance.api.getSubMenu(id))
        }
    }
}