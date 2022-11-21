package com.g3c1.temiuser.domain.purchase.utils.impl

import com.g3c1.temiuser.domain.food.domain.entity.Food
import com.g3c1.temiuser.domain.purchase.domain.entity.Purchase
import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.OrderedFoodDto
import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.PurchasedFoodListDto
import com.g3c1.temiuser.domain.purchase.presentaion.data.request.PurchasedFoodRequest
import com.g3c1.temiuser.domain.purchase.presentaion.data.response.MyPurchasedFoodListResponse
import com.g3c1.temiuser.domain.purchase.presentaion.data.response.PurchasedFoodListResponse
import com.g3c1.temiuser.domain.purchase.utils.PurchaseConverter
import com.g3c1.temiuser.domain.seat.domain.entity.Seat
import org.springframework.stereotype.Component

@Component
class PurchaseConverterImpl(
): PurchaseConverter {
    override fun toDto(purchasedFoodRequest: PurchasedFoodRequest): OrderedFoodDto =
        OrderedFoodDto(purchasedFoodRequest.seatId,purchasedFoodRequest.foodList.map { OrderedFoodDto.OrderedFoodInfoDto(it.foodId,it.foodCount) })

    override fun toEntity(seat: Seat, food: Food, foodCount: Long): Purchase = Purchase(food,seat,foodCount)
    override fun toResponse(dto: List<PurchasedFoodListDto>): List<PurchasedFoodListResponse> =
        dto.map { PurchasedFoodListResponse(
                it.seat.id,
                it.seat.seatNumber,
                it.foodInfoList.map { foodInfo-> PurchasedFoodListResponse.FoodInfoResponse(foodInfo.food.name, foodInfo.foodCount) })
        }

    override fun toResponse(dto: PurchasedFoodListDto): MyPurchasedFoodListResponse =
        MyPurchasedFoodListResponse(dto.foodInfoList.map { MyPurchasedFoodListResponse.FoodInfoResponse(it.food.name,it.food.img,it.food.price,it.food.servings,it.foodCount)},
            dto.sequence)
}