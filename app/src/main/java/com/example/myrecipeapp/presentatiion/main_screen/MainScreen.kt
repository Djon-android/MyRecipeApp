package com.example.myrecipeapp.presentatiion.main_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myrecipeapp.navigation.AppNavGraph
import com.example.myrecipeapp.navigation.Screen
import com.example.myrecipeapp.navigation.rememberNavigationState
import com.example.myrecipeapp.presentatiion.categories_screen.CategoriesScreen
import com.example.myrecipeapp.presentatiion.category_detail_screen.CategoryDetailScreen
import com.example.myrecipeapp.presentatiion.ui.theme.MyRecipeAppTheme

@Composable
fun MainScreen() {

    val navigationState = rememberNavigationState()

    MyRecipeAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AppNavGraph(
                navHostController = navigationState.navHostController,
                startDestinationScreen = Screen.CategoriesScreen,
                categoriesScreenContent = {
                    CategoriesScreen(
                        navigationToDetails = {
                            navigationState.navigate(
                                Screen.CategoryDetailScreen.getCategoryDetailRoute(it)
                            )
                        }
                    )
                },
                categoryDetailsScreen = {
                    CategoryDetailScreen(
                        category = it
                    )
                }
            )
        }
    }
}