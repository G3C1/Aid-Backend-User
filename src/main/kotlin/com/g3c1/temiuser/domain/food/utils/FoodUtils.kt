package com.g3c1.temiuser.domain.food.utils

import com.g3c1.temiuser.domain.category.domain.entity.Category
import com.g3c1.temiuser.domain.food.domain.entity.Food
import com.g3c1.temiuser.domain.food.presentation.data.dto.CategoryFoodListDto

interface FoodUtils {
    fun findFoodBySeatId(seatId: Long): Food
    fun findFoodByCategory(category: Category): List<CategoryFoodListDto.FoodDto>
}