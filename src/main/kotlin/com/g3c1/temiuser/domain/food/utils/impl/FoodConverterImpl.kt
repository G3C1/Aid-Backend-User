package com.g3c1.temiuser.domain.food.utils.impl

import com.g3c1.temiuser.domain.food.presentation.data.dto.CategoryFoodListDto
import com.g3c1.temiuser.domain.food.presentation.data.response.CategoryFoodListResponse
import com.g3c1.temiuser.domain.food.presentation.data.response.FoodResponse
import com.g3c1.temiuser.domain.food.utils.FoodConverter
import org.springframework.stereotype.Component

@Component
class FoodConverterImpl:FoodConverter {
    override fun toResponse(categoryFoodListDto: List<CategoryFoodListDto>): List<CategoryFoodListResponse> =
        categoryFoodListDto.toList().map {
            CategoryFoodListResponse(it.id, it.category, foodList = it.foodList.toList().map
            { food -> FoodResponse(food.id, food.name, food.img, food.description, food.servings, food.price) }) }
}