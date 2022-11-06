package com.g3c1.temiuser.domain.food.service

import com.g3c1.temiuser.domain.food.presentation.data.dto.CategoryFoodListDto

interface FoodService {
    fun findFoodListByCategory(): List<CategoryFoodListDto>
}