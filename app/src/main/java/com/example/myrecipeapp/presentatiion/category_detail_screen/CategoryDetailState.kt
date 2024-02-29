package com.example.myrecipeapp.presentatiion.category_detail_screen

import com.example.myrecipeapp.domain.model.Category

sealed class CategoryDetailState {

    data object Initial : CategoryDetailState()

    data object Loading : CategoryDetailState()

    data object Error : CategoryDetailState()

    data class CategoryDetail(
        val category: Category
    ) : CategoryDetailState()
}