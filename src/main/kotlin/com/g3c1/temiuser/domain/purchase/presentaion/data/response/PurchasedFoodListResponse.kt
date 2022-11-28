package com.g3c1.temiuser.domain.purchase.presentaion.data.response

data class PurchasedFoodListResponse(
    val seatId: Long,
    val seatNumber: Long,
    val foodInfoList: List<FoodInfoResponse>
){
    data class FoodInfoResponse(
        val foodImg: String,
        val foodName: String,
        val price: Long,
        val foodCount: Long
    )
}
