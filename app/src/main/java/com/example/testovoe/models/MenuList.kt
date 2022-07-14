package com.example.testovoe.models

import com.example.testovoe.R
import com.google.gson.annotations.SerializedName

data class MenuList (
    @SerializedName("menuID"       ) var menuID       : String? = null,
    @SerializedName("image"        ) var image        : String? = null,
    @SerializedName("name"         ) var name         : String? = null,
    @SerializedName("subMenuCount" ) var subMenuCount : String? = null
)