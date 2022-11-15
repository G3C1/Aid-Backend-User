package com.g3c1.temiuser.domain.purchase.service.impl

import com.g3c1.temiuser.domain.food.utils.FoodUtils
import com.g3c1.temiuser.domain.purchase.domain.entity.Purchase
import com.g3c1.temiuser.domain.purchase.domain.repository.PurchaseRepository
import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.PurchasedFoodDto
import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.PurchasedFoodListDto
import com.g3c1.temiuser.domain.purchase.service.PurchaseService
import com.g3c1.temiuser.domain.purchase.utils.PurchaseConverter
import com.g3c1.temiuser.domain.seat.domain.entity.Seat
import com.g3c1.temiuser.domain.seat.utils.SeatUtils
import com.g3c1.temiuser.domain.seat.utils.SeatValidator
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.function.Consumer

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
        val seat:Seat = seatUtils.findSeatById(purchasedFoodDto.seatId)
                        .let { seatValidator.checkIsNotUsed(it) }

        val purchaseList = purchasedFoodDto.foodList
            .map { foodUtils.findFoodBySeatId(it.foodId) to it.foodCount }
            .map { (food,foodCount) -> purchaseConverter.toEntity(seat,food,foodCount) }

        purchaseRepository.saveAll(purchaseList)
    }

    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    override fun findPurchasedList(): List<PurchasedFoodListDto> =
        getSeatIdList(purchaseRepository.findAll())
            .let { seat-> seat.map { PurchasedFoodListDto(it.id,it.seatNumber,getFoodInfo(it)) } }
    private fun getSeatIdList(purchases: List<Purchase>):List<Seat> =
        purchases.map { it.seat }.distinct()
    private fun getFoodInfo(seat: Seat): List<PurchasedFoodListDto.FoodInfo> =
        purchaseRepository.findPurchaseBySeat(seat)
            .map { PurchasedFoodListDto.FoodInfo(it.food.name,it.foodCount) }

    @Transactional(rollbackFor = [Exception::class])
    override fun deletePurchase(seatId: Long) {
        purchaseRepository.findPurchaseBySeat(seatUtils.findSeatById(seatId))
    }
}