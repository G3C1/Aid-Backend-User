package com.g3c1.temiuser.domain.purchase.utils

import com.g3c1.temiuser.domain.food.domain.entity.Food
import com.g3c1.temiuser.domain.purchase.domain.entity.Purchase
import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.FindPurchasedFoodDto
import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.OrderedFoodDto
import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.PurchasedFoodListDto
import com.g3c1.temiuser.domain.purchase.presentaion.data.request.FindPurchasedFoodRequest
import com.g3c1.temiuser.domain.purchase.presentaion.data.request.PurchasedFoodRequest
import com.g3c1.temiuser.domain.purchase.presentaion.data.response.MyPurchasedFoodListResponse
import com.g3c1.temiuser.domain.purchase.presentaion.data.response.PurchasedFoodListResponse
import com.g3c1.temiuser.domain.seat.domain.entity.Seat

interface PurchaseConverter {
    fun toDto(purchasedFoodRequest: PurchasedFoodRequest): OrderedFoodDto
    fun toDto(request: FindPurchasedFoodRequest): FindPurchasedFoodDto
    fun toEntity(seat: Seat, food:Food,foodCount: Long, serialNumber: Long): Purchase
    fun toResponse(dto:List<PurchasedFoodListDto>): List<PurchasedFoodListResponse>
    fun toResponse(dto:PurchasedFoodListDto): MyPurchasedFoodListResponse
}