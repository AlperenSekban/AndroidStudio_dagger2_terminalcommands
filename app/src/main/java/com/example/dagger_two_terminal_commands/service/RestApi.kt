package com.example.dagger_two_terminal_commands.service

import com.example.dagger_two_terminal_commands.models.CategoriesModel
import com.example.dagger_two_terminal_commands.models.CategoryInfoModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestApi {

    @GET("/api/categories?language=TR")
    fun getCategories(): Call<List<CategoriesModel>>

    @GET("/api/categories/{categoryId}/commands")
    fun getCategoryInfo(@Path("categoryId") categoryId:String):Call<List<CategoryInfoModel>>

}