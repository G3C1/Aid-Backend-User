package com.g3c1.temiuser.domain.purchase.utils

import com.g3c1.temiuser.domain.food.domain.entity.Food
import com.g3c1.temiuser.domain.purchase.domain.entity.Purchase
import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.PurchasedFoodDto
import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.PurchasedFoodListDto
import com.g3c1.temiuser.domain.purchase.presentaion.data.request.PurchasedFoodRequest
import com.g3c1.temiuser.domain.purchase.presentaion.data.response.PurchasedFoodListResponse
import com.g3c1.temiuser.domain.seat.domain.entity.Seat

interface PurchaseConverter {
    fun toDto(purchasedFoodRequest: PurchasedFoodRequest): PurchasedFoodDto
    fun toEntity(seat: Seat, food:Food,foodCount: Long ): Purchase
    fun toResponse(purchasedFoodListDto:List<PurchasedFoodListDto>): List<PurchasedFoodListResponse>
}