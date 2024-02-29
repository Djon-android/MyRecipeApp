package com.example.myrecipeapp.domain.repository

import com.example.myrecipeapp.domain.model.Category
import com.example.myrecipeapp.utils.LoadResource
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun getCategories(): Flow<LoadResource<List<Category>?>>
}