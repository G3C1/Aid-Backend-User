package com.g3c1.temiuser.domain.food.presentation.data.response

class CategoryFoodListResponse (
    val id: Long,
    val category: String,
    val foodList: List<FoodResponse>
)