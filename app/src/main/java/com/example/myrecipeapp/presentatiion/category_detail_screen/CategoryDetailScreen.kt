package com.example.myrecipeapp.presentatiion.category_detail_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.myrecipeapp.domain.model.Category

@Composable
fun CategoryDetailScreen(
    category: String,
    viewModel: CategoryDetailViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle()

    CategoryDetailScreenContent(
        screenState = state
    )
}

@Composable
fun CategoryDetailScreenContent(
    screenState: State<CategoryDetailState>
) {
    when (val currentState = screenState.value) {
        is CategoryDetailState.Initial -> {}

        is CategoryDetailState.CategoryDetail -> {
            CategoryDetail(currentState.category)
        }

        is CategoryDetailState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Error")
            }
        }

        is CategoryDetailState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
    }
}

@Composable
fun CategoryDetail(
    category: Category
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = category.name,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        AsyncImage(
            modifier = Modifier
                .wrapContentSize()
                .aspectRatio(1f),
            model = category.icon,
            contentDescription = "${category.name} image"
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            text = category.description,
            textAlign = TextAlign.Justify
        )
    }
}