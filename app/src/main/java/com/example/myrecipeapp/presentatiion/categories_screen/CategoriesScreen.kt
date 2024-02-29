package com.example.myrecipeapp.presentatiion.categories_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.myrecipeapp.domain.model.Category
import kotlinx.collections.immutable.ImmutableList

@Composable
fun CategoriesScreen(
    viewModel: CategoriesViewModel = hiltViewModel(),
    navigationToDetails: (Category) -> Unit
) {
    val screenState = viewModel.screenState.collectAsStateWithLifecycle(CategoriesState.Initial)

    CategoriesScreenContent(
        screenState = screenState,
        viewModel = viewModel,
        navigationToDetails = navigationToDetails
    )
}

@Composable
fun CategoriesScreenContent(
    screenState: State<CategoriesState>,
    viewModel: CategoriesViewModel,
    navigationToDetails: (Category) -> Unit
) {
    when (val currentState = screenState.value) {
        is CategoriesState.Initial -> {}
        is CategoriesState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is CategoriesState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Error")
            }
        }

        is CategoriesState.Categories -> {
            CategoriesList(
                viewModel = viewModel,
                categories = currentState.categories,
                navigationToDetails = navigationToDetails
            )
        }
    }
}

@Composable
fun CategoriesList(
    viewModel: CategoriesViewModel,
    categories: ImmutableList<Category>?,
    navigationToDetails: (Category) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2)
    ) {
        categories?.let {
            items(items = categories) {
                CategoryItem(
                    category = it,
                    viewModel = viewModel,
                    navigationToDetails = navigationToDetails
                )
            }
        }
    }
}

@Composable
fun CategoryItem(
    category: Category,
    viewModel: CategoriesViewModel,
    navigationToDetails: (Category) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable {
                navigationToDetails(category)
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .wrapContentSize()
                .aspectRatio(1f),
            imageLoader = viewModel.imageLoader,
            model = category.icon,
            contentDescription = null
        )

        Text(
            modifier = Modifier
                .padding(top = 4.dp),
            text = category.name,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
    }
}