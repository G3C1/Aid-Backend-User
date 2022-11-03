package com.g3c1.temiuser.domain.category.utils

import com.g3c1.temiuser.domain.category.domain.entity.Category
import com.g3c1.temiuser.domain.category.presentaion.data.dto.CategoryDto
import com.g3c1.temiuser.domain.category.presentaion.data.request.CreateCategoryListRequest

interface CategoryConverter {
    fun toDto(createCategoryListRequest: CreateCategoryListRequest): CategoryDto
    fun toEntity(dto: CategoryDto): List<Category>
}