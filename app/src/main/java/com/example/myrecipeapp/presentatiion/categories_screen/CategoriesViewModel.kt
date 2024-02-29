package com.example.myrecipeapp.presentatiion.categories_screen

import androidx.lifecycle.ViewModel
import coil.ImageLoader
import com.example.myrecipeapp.domain.usecases.GetCategoriesUseCase
import com.example.myrecipeapp.utils.LoadResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    val imageLoader: ImageLoader
): ViewModel() {

    private val categoriesFlow = getCategoriesUseCase()

    val screenState = categoriesFlow
        .map { result ->
            when(result) {
                is LoadResource.Success -> {
                    CategoriesState.Categories(categories = result.data?.toImmutableList()) as CategoriesState
                }
                is LoadResource.Error -> {
                    CategoriesState.Error as CategoriesState
                }
                is LoadResource.Loading -> {
                    CategoriesState.Loading as CategoriesState
                }
            }
        }
        .onStart { emit(CategoriesState.Loading) }
}