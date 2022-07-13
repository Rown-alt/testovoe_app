package com.example.testovoe.api

import com.example.testovoe.models.MenuRequest
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TestovoeApi {
    @POST("getMenu.php")
    suspend fun getCategories(
//        @Field("status") status : Boolean,
//        @Field("menuList") menuList : List<String>
//        @Field("menuID") menuID : String,
//        @Field("image") image : String,
//        @Field("name") name : String,
//        @Field("subMenuCount") subMenuCount : Int,
    ) : MenuRequest
    @FormUrlEncoded
    @POST("getSubMenu.php")
    suspend fun getSubMenu(
        @Field("menuID") menuID : String
    ) : MenuRequest
}