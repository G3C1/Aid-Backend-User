package com.g3c1.temiuser.domain.purchase.service

import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.PurchasedFoodListDto

interface PurchaseServiceV2 {
    fun findFoodListBySeatId(seatId:Long): PurchasedFoodListDto
    fun findPurchasedList(serialNumber:Long): List<PurchasedFoodListDto>
}