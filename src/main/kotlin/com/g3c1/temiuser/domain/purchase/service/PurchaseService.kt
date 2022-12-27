package com.g3c1.temiuser.domain.purchase.service

import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.OrderedFoodDto
import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.PurchasedFoodListDto

interface PurchaseService {
    fun createPurchasedFoodList(orderedFoodDto: OrderedFoodDto,serialNumber: Long)
    fun findPurchasedList(): List<PurchasedFoodListDto>
    fun deletePurchase(seatId: Long)
}