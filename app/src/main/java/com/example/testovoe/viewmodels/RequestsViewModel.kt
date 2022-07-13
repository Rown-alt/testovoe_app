package com.example.testovoe.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testovoe.api.RetrofitInstance
import com.example.testovoe.models.MenuList
import com.example.testovoe.models.MenuRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RequestsViewModel : ViewModel(){

    var subMenuList = MutableLiveData<MenuRequest>()
    var menuList = MutableLiveData<MenuRequest>()
    fun getMenu(){
        viewModelScope.launch(Dispatchers.IO) {
            menuList.postValue(RetrofitInstance.api.getCategories())
        }
    }
    fun getSubMenu(id : String){
        viewModelScope.launch(Dispatchers.IO) {
            subMenuList.postValue(RetrofitInstance.api.getSubMenu(id))
        }
    }
}