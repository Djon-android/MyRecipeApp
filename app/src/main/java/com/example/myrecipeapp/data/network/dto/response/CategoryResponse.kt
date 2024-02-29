package com.example.myrecipeapp.data.network.dto.response

import com.example.myrecipeapp.data.network.dto.CategoryDto
import com.google.gson.annotations.SerializedName

data class CategoryResponse(

    @SerializedName("categories")
    val categories: List<CategoryDto>?
)
