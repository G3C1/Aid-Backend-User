package com.g3c1.temiuser.domain.purchase.service

import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.PurchasedFoodDto

interface PurchaseService {
    fun createPurchasedFoodList(purchasedFoodDto: PurchasedFoodDto)
}