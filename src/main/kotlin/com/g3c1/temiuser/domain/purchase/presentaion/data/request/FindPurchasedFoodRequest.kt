package com.g3c1.temiuser.domain.purchase.presentaion.data.request

data class FindPurchasedFoodRequest (
    val seatId: Long,
    val serialNumber: Long
)