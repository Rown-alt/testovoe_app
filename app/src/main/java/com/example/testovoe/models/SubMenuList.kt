package com.example.testovoe.models

import com.google.gson.annotations.SerializedName

data class SubMenuList (
@SerializedName("id") var menuID : String? = null,
@SerializedName("image") var image : String? = null,
@SerializedName("name") var name : String? = null,
@SerializedName("content") var content : String? = null,
@SerializedName("price" ) var price : String? = null,
@SerializedName("weight" ) var weight : String? = null,
@SerializedName("spicy" ) var spicy : String? = null,
)