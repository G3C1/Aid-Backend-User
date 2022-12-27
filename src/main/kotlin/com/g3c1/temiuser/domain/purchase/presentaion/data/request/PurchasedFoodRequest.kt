package com.g3c1.temiuser.domain.purchase.presentaion.data.request

import org.jetbrains.annotations.NotNull

data class PurchasedFoodRequest(
    @field: NotNull
    val serialNumber: Long,
    @field: NotNull
    val seatId: Long,
    @field: NotNull
    val foodList: List<OrderedFoodInfoRequest>
){
    data class OrderedFoodInfoRequest (
        val foodId: Long,
        val foodCount: Long
    )
}