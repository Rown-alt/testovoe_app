package com.example.testovoe.api

import com.example.testovoe.models.MenuRequest
import com.example.testovoe.models.SubMenuRequest
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TestovoeApi {
    @POST("getMenu.php")
    suspend fun getCategories() : Result<MenuRequest>
    @FormUrlEncoded
    @POST("getSubMenu.php")
    suspend fun getSubMenu(@Field("menuID") menuID : String) : Result<SubMenuRequest>
}