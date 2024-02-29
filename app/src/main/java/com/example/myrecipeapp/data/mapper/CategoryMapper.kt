package com.example.myrecipeapp.data.mapper

import com.example.myrecipeapp.data.network.dto.CategoryDto
import com.example.myrecipeapp.domain.model.Category
import com.example.myrecipeapp.utils.Constants.UNKNOWN_ID

fun CategoryDto.toCategory() = Category(
    id = try {
        id?.toInt() ?: UNKNOWN_ID
    } catch (e: Exception) {
        UNKNOWN_ID
    },
    name = name ?: "",
    icon = icon ?: "",
    description = description ?: ""
)