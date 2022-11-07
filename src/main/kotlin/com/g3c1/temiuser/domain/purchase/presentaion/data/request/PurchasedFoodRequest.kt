package com.g3c1.temiuser.domain.purchase.presentaion.data.request

data class PurchasedFoodRequest(
    val seatId: Long,
    val foodList: List<OrderedFoodInfoRequest>
){
    data class OrderedFoodInfoRequest (
        val foodId: Long,
        val foodCount: Long
    )
}