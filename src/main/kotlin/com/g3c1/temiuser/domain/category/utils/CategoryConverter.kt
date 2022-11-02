package com.g3c1.temiuser.domain.category.utils

import com.g3c1.temiuser.domain.category.domain.entity.Category
import com.g3c1.temiuser.domain.category.presentaion.data.dto.CategoryDto
import com.g3c1.temiuser.domain.category.presentaion.data.request.CreateCategoryRequest

interface CategoryConverter {
    fun toDto(createCategoryRequest: CreateCategoryRequest): CategoryDto
    fun toEntity(dto: CategoryDto): List<Category>
}