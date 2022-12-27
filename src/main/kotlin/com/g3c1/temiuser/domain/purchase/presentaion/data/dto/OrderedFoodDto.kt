package com.g3c1.temiuser.domain.purchase.presentaion.data.dto

data class OrderedFoodDto (
    val serialNumber: Long,
    val seatId: Long,
    val foodList: List<OrderedFoodInfoDto>
){
    data class OrderedFoodInfoDto (
        val foodId: Long,
        val foodCount: Long
    )
}