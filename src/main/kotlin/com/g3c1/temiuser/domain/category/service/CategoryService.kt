package com.g3c1.temiuser.domain.category.service

import com.g3c1.temiuser.domain.category.presentaion.data.request.CreateCategoryRequest

interface CategoryService {
    fun createCategory(createCategoryDto: CreateCategoryRequest)
}