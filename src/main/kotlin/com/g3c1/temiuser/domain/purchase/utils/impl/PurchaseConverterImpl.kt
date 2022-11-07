package com.g3c1.temiuser.domain.purchase.utils.impl

import com.g3c1.temiuser.domain.food.domain.entity.Food
import com.g3c1.temiuser.domain.purchase.domain.entity.Purchase
import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.PurchasedFoodDto
import com.g3c1.temiuser.domain.purchase.presentaion.data.request.PurchasedFoodRequest
import com.g3c1.temiuser.domain.purchase.utils.PurchaseConverter
import com.g3c1.temiuser.domain.seat.domain.entity.Seat
import org.springframework.stereotype.Component

@Component
class PurchaseConverterImpl(
): PurchaseConverter {
    override fun toDto(purchasedFoodRequest: PurchasedFoodRequest): PurchasedFoodDto =
        PurchasedFoodDto(purchasedFoodRequest.seatId,purchasedFoodRequest.foodList.map { PurchasedFoodDto.OrderedFoodInfoDto(it.foodId,it.foodCount) })

    override fun toEntity(seat: Seat, food: Food, foodCount: Long): Purchase = Purchase(food,seat,foodCount)


}