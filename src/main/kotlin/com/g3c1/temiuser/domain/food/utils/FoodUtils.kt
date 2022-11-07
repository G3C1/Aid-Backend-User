package com.g3c1.temiuser.domain.food.utils

import com.g3c1.temiuser.domain.food.domain.entity.Food

interface FoodUtils {
    fun findFoodById(seatId: Long): Food
}