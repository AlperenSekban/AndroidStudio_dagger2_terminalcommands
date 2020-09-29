package com.example.dagger_two_terminal_commands.models


import com.google.gson.annotations.SerializedName

data class CategoriesModel(
    @SerializedName("_id")
    val id: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("__v")
    val v: Int
)