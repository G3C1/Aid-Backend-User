package com.g3c1.temiuser.domain.purchase.presentaion.data.dto


data class PurchasedFoodListDto (
    val seatId: Long,
    val seatNumber: Long,
    val foodInfoList: List<FoodInfo>
){
    data class FoodInfo(
        val foodName: String,
        val foodCount: Long
    )
}