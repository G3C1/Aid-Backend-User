package com.g3c1.temiuser.domain.food.utils

import com.g3c1.temiuser.domain.food.presentation.data.dto.CategoryFoodListDto
import com.g3c1.temiuser.domain.food.presentation.data.response.CategoryFoodListResponse

interface FoodConverter {
    fun toResponse(categoryFoodListDto: List<CategoryFoodListDto>): List<CategoryFoodListResponse>
}