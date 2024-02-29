package com.example.myrecipeapp.data.network

import com.example.myrecipeapp.data.network.dto.response.CategoryResponse
import retrofit2.http.GET

interface ApiService {

    @GET("categories.php")
    suspend fun getCategories(): CategoryResponse
}