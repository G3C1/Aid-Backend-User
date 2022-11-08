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
        seatUtils.findSeatById(purchasedFoodDto.seatId)
            .let { seatValidator.checkIsNotUsed(it) }
            .let { seat -> purchasedFoodDto.foodList.map { purchaseConverter.toEntity(seat,foodUtils.findFoodById(it.foodId),it.foodCount) }}
            .let { println(it); purchaseRepository.saveAll(it) }
    }

    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    override fun findPurchasedList(): List<PurchasedFoodListDto> =
        getSeatIdList(purchaseRepository.findAll())
            .let { seat-> seat.map { PurchasedFoodListDto(it.id,it.seatNumber,getFoodInfo(it)) } }
    private fun getSeatIdList(purchases: List<Purchase>):List<Seat>{
        val seatList: ArrayList<Seat> = ArrayList()
        purchases.forEach(Consumer { purchase: Purchase ->
            if (seatList.equals(purchase.seat))
            else seatList.add(purchase.seat)
        })
        return seatList.distinct()
    }
    private fun getFoodInfo(seat: Seat): List<PurchasedFoodListDto.FoodInfo> =
        purchaseRepository.findPurchaseBySeat(seat).map { PurchasedFoodListDto.FoodInfo(it.food.name,it.foodCount) }

    @Transactional(rollbackFor = [Exception::class])
    override fun deletePurchase(seatId: Long) {
        purchaseRepository.findPurchaseBySeat(seatUtils.findSeatById(seatId))
    }
}