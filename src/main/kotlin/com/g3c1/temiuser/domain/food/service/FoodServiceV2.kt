package com.g3c1.temiuser.domain.food.service

import com.g3c1.temiuser.domain.food.presentation.data.dto.CategoryFoodListDto

interface FoodServiceV2 {
    fun findFoodListBySerialNumber(serialNumber: Long): List<CategoryFoodListDto>
}