package com.g3c1.temiuser.domain.food.presentation.data.dto


data class CategoryFoodListDto(
    val id: Long,
    val category: String,
    val foodList: List<FoodDto>
)
