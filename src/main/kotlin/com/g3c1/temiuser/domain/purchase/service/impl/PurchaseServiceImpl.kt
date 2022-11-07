package com.g3c1.temiuser.domain.purchase.service.impl

import com.g3c1.temiuser.domain.food.utils.FoodUtils
import com.g3c1.temiuser.domain.purchase.domain.repository.PurchaseRepository
import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.PurchasedFoodDto
import com.g3c1.temiuser.domain.purchase.service.PurchaseService
import com.g3c1.temiuser.domain.purchase.utils.PurchaseConverter
import com.g3c1.temiuser.domain.seat.utils.SeatUtils
import com.g3c1.temiuser.domain.seat.utils.SeatValidator
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PurchaseServiceImpl(
    private val purchaseRepository: PurchaseRepository,
    private val foodUtils: FoodUtils,
    private val seatUtils: SeatUtils,
    private val seatValidator: SeatValidator,
    private val purchaseConverter: PurchaseConverter
): PurchaseService {
    @Transactional(rollbackFor = [Exception::class])
    override fun createPurchasedFoodList(purchasedFoodDto: PurchasedFoodDto) {
        seatUtils.findSeatById(purchasedFoodDto.seatId)
            .let { seatValidator.checkIsNotUsed(it) }
            .let { seat -> purchasedFoodDto.foodList.map { purchaseConverter.toEntity(seat,foodUtils.findFoodById(it.foodId),it.foodCount) }}
            .let { purchaseRepository.saveAll(it) }
    }
}