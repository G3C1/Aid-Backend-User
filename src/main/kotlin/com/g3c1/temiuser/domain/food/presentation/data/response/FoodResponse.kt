package com.g3c1.temiuser.domain.food.presentation.data.response

data class FoodResponse(
    val id: Long,
    val name: String,
    val img: String,
    val description: String,
    val servings: Long,
    val price: Long
)
