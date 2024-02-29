package com.example.myrecipeapp.presentatiion.category_detail_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myrecipeapp.domain.model.Category
import com.example.myrecipeapp.utils.Constants.EXTRA_CATEGORY_AS_STRING
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _uiState = MutableStateFlow(CategoryDetailState.Initial as CategoryDetailState)
    val uiState: StateFlow<CategoryDetailState> = _uiState.asStateFlow()


    init {
        val categoryJson = savedStateHandle[EXTRA_CATEGORY_AS_STRING] ?: ""
        val category = try {
            Gson().fromJson(categoryJson, Category::class.java)
        } catch (e: Exception) {
            null
        }
        _uiState.value = if (category == null) {
            CategoryDetailState.Error
        } else {
            CategoryDetailState.CategoryDetail(category)
        }
    }
}