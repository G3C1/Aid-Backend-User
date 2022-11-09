package com.g3c1.temiuser.domain.food.presentation

import com.g3c1.temiuser.domain.food.presentation.data.response.CategoryFoodListResponse
import com.g3c1.temiuser.domain.food.service.FoodService
import com.g3c1.temiuser.domain.food.utils.FoodConverter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/food")
class FoodController(
    private val foodConverter: FoodConverter,
    private val foodService: FoodService
) {
    @GetMapping
    fun findFoodList(): ResponseEntity<List<CategoryFoodListResponse>> =
        foodService.findFoodList()
            .let {foodConverter.toResponse(it)}
            .let { ResponseEntity.ok().body(it) }
}