package com.g3c1.temiuser.domain.category.utils.impl

import com.g3c1.temiuser.domain.category.domain.entity.Category
import com.g3c1.temiuser.domain.category.presentaion.data.dto.CategoryDto
import com.g3c1.temiuser.domain.category.presentaion.data.request.CreateCategoryRequest
import com.g3c1.temiuser.domain.category.utils.CategoryConverter
import org.springframework.stereotype.Component

@Component
class CategoryConverterImpl : CategoryConverter {
    override fun toDto(createCategoryRequest: CreateCategoryRequest): CategoryDto = CategoryDto(createCategoryRequest.categoryList)

    override fun toEntity(dto: CreateCategoryRequest): List<Category> = dto.categoryList.toList().map { Category(it) }
}