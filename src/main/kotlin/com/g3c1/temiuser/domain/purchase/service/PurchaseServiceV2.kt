package com.g3c1.temiuser.domain.purchase.service

import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.FindPurchasedFoodDto
import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.PurchasedFoodListDto

interface PurchaseServiceV2 {
    fun findFoodListBySeatId(dto: FindPurchasedFoodDto): PurchasedFoodListDto
    fun findPurchasedList(serialNumber:Long): List<PurchasedFoodListDto>
}