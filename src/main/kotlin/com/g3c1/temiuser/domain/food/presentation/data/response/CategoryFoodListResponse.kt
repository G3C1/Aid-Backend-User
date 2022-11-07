package com.g3c1.temiuser.domain.food.presentation.data.response

data class CategoryFoodListResponse (
    val id: Long,
    val category: String,
    val foodList: List<FoodInfoResponse>
){
    data class FoodInfoResponse(
        val id: Long,
        val name: String,
        val img: String,
        val description: String,
        val servings: Long,
        val price: Long
    )
}