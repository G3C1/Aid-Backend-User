package com.g3c1.temiuser.domain.category.service

import com.g3c1.temiuser.domain.category.presentaion.data.dto.CategoryDto

interface CategoryService {
    fun createCategory(createCategoryDto: CategoryDto)
}