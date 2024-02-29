package com.example.myrecipeapp.presentatiion.categories_screen

import com.example.myrecipeapp.domain.model.Category
import kotlinx.collections.immutable.ImmutableList

sealed class CategoriesState {

    data object Initial : CategoriesState()

    data object Loading : CategoriesState()

    data object Error : CategoriesState()

    data class Categories(
        val categories: ImmutableList<Category>?
    ) : CategoriesState()
}