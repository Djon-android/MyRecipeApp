package com.example.myrecipeapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class CategoryDto(

    @SerializedName("idCategory")
    val id: String? = null,

    @SerializedName("strCategory")
    val name: String? = null,

    @SerializedName("strCategoryThumb")
    val icon: String? = null,

    @SerializedName("strCategoryDescription")
    val description: String? = null
)