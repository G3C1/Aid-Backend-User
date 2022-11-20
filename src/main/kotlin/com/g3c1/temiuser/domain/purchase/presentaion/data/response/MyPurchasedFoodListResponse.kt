package com.g3c1.temiuser.domain.purchase.presentaion.data.response

data class MyPurchasedFoodListResponse (
    val seatId: Long,
    val foodInfoList: List<FoodInfoResponse>,
    val sequence: Int
){
    data class FoodInfoResponse(
        val foodName: String,
        val foodImg: String,
        val price: Long,
        val servings: Long,
        val foodCount: Long
    )
}