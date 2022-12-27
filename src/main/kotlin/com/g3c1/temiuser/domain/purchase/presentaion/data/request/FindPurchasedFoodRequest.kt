package com.g3c1.temiuser.domain.purchase.presentaion.data.request

import org.jetbrains.annotations.NotNull

data class FindPurchasedFoodRequest (
    @field: NotNull
    val seatId: Long,
    @field: NotNull
    val serialNumber: Long
)