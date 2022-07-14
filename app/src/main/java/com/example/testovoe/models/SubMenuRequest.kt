package com.example.testovoe.models

import com.google.gson.annotations.SerializedName

data class SubMenuRequest (
    @SerializedName("status"   ) var status   : String?             = null,
    @SerializedName("menuList" ) var menuList : ArrayList<SubMenuList> = arrayListOf()
        )