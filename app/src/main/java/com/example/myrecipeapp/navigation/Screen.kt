package com.example.myrecipeapp.navigation

import com.example.myrecipeapp.domain.model.Category
import com.example.myrecipeapp.utils.extensions.encode
import com.google.gson.Gson

sealed class Screen(val route: String) {
    data object CategoriesScreen : Screen("categories_screen")
    data object CategoryDetailScreen : Screen("category_detail_screen") {
        fun getCategoryDetailRoute(
            category: Category
        ): String {
            val categoryJson = Gson().toJson(category)
            return "${CategoryDetailScreen.route}/${categoryJson.encode()}"
        }
    }
}