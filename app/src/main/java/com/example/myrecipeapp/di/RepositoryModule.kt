package com.example.myrecipeapp.di

import com.example.myrecipeapp.data.repository.CategoryRepositoryImpl
import com.example.myrecipeapp.domain.repository.CategoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCategoryRepository(impl: CategoryRepositoryImpl): CategoryRepository
}