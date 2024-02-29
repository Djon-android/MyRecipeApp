package com.example.myrecipeapp.domain.usecases

import com.example.myrecipeapp.domain.repository.CategoryRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: CategoryRepository
) {

    operator fun invoke() = repository.getCategories()
}