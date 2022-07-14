package com.example.testovoe.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testovoe.api.RetrofitInstance
import com.example.testovoe.models.MenuRequest
import com.example.testovoe.models.SubMenuRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RequestsViewModel : ViewModel(){

    var subMenuList = MutableLiveData<SubMenuRequest>()
    var menuList = MutableLiveData<MenuRequest>()

    var exception = MutableLiveData<Int>()
    fun getMenu(){
        viewModelScope.launch(Dispatchers.IO) {
            RetrofitInstance.api.getCategories().onSuccess {
                menuList.postValue(it)
            }
            RetrofitInstance.api.getCategories().onFailure {
                exception.postValue(1)
            }
        }
    }
    fun getSubMenu(id : String){
        viewModelScope.launch(Dispatchers.IO) {
            RetrofitInstance.api.getSubMenu(id).onSuccess {
                subMenuList.postValue(it)
            }
            RetrofitInstance.api.getSubMenu(id).onFailure {
                exception.postValue(1)
            }
        }
    }
}