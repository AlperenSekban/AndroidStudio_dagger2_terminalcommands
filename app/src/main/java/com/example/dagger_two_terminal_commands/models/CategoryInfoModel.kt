package com.example.dagger_two_terminal_commands.models


import com.google.gson.annotations.SerializedName

data class CategoryInfoModel(
    @SerializedName("category")
    val category: String,
    @SerializedName("detail")
    val detail: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("__v")
    val v: Int
)