package com.example.myrecipeapp.data.repository

import com.example.myrecipeapp.data.mapper.toCategory
import com.example.myrecipeapp.data.network.ApiService
import com.example.myrecipeapp.domain.model.Category
import com.example.myrecipeapp.domain.repository.CategoryRepository
import com.example.myrecipeapp.utils.LoadResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): CategoryRepository {

    override fun getCategories(): Flow<LoadResource<List<Category>?>> {
        return flow {
            try {
                val categories = apiService.getCategories().categories?.map { it.toCategory() }
                emit(LoadResource.Success(categories))
            } catch (e: Exception) {
                emit(LoadResource.Error("Неизвестная ошибка"))
            }
        }
    }
}