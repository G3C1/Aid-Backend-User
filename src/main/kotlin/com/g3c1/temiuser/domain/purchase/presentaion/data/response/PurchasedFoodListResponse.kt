package com.g3c1.temiuser.domain.purchase.presentaion.data.response

data class PurchasedFoodListResponse(
    val seatId: Long,
    val seatNumber: Long,
    val foodInfoList: List<FoodInfoResponse>
){
    data class FoodInfoResponse(
        val foodName: String,
        val foodImg: String,
        val price: Long,
        val foodCount: Long
    )
}
