package com.example.myrecipeapp.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myrecipeapp.utils.Constants.EXTRA_CATEGORY_AS_STRING

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    startDestinationScreen: Screen,
    categoriesScreenContent: @Composable () -> Unit,
    categoryDetailsScreen: @Composable (String) -> Unit
) {
    NavHost(navController = navHostController, startDestination = startDestinationScreen.route) {
        composable(
            route = Screen.CategoriesScreen.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right
                )
            }
        ) {
            categoriesScreenContent()
        }
        composable(
            route = "${Screen.CategoryDetailScreen.route}/{$EXTRA_CATEGORY_AS_STRING}",
            arguments = listOf(
                navArgument(EXTRA_CATEGORY_AS_STRING) {
                    type = NavType.StringType
                }
            ),
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right
                )
            }
        ) { backStackEntry ->
            categoryDetailsScreen(
                backStackEntry.arguments?.getString(EXTRA_CATEGORY_AS_STRING, "") ?: ""
            )
        }
    }
}