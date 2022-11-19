package com.g3c1.temiuser.domain.purchase.presentaion.data.dto

import com.g3c1.temiuser.domain.food.domain.entity.Food
import com.g3c1.temiuser.domain.seat.domain.entity.Seat


data class PurchasedFoodListDto (
    val seat: Seat,
    val foodInfoList: List<FoodInfo>
){
    data class FoodInfo(
        val food: Food,
        val foodCount: Long
    )
}