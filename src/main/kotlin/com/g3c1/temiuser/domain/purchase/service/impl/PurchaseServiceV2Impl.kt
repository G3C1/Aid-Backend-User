package com.g3c1.temiuser.domain.purchase.service.impl

import com.g3c1.temiuser.domain.purchase.domain.entity.Purchase
import com.g3c1.temiuser.domain.purchase.domain.repository.PurchaseRepository
import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.PurchasedFoodListDto
import com.g3c1.temiuser.domain.purchase.service.PurchaseServiceV2
import com.g3c1.temiuser.domain.seat.domain.entity.Seat
import com.g3c1.temiuser.domain.seat.utils.SeatUtils
import com.g3c1.temiuser.domain.store.utils.StoreUtils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PurchaseServiceV2Impl(
    private val purchaseRepository: PurchaseRepository,
    private val seatUtils: SeatUtils,
    private val storeUtils: StoreUtils
):PurchaseServiceV2 {
    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    override fun findFoodListBySeatId(seatId: Long): PurchasedFoodListDto =
        seatUtils.findSeatById(seatId)
            .let { PurchasedFoodListDto(it,getFoodInfo(it),findSequence(it)) }
    private fun getFoodInfo(seat: Seat): List<PurchasedFoodListDto.FoodInfoDto> =
        purchaseRepository.findPurchaseBySeat(seat)
            .map { PurchasedFoodListDto.FoodInfoDto(it.food,it.foodCount) }
    private fun getSeatIdList(purchases: List<Purchase>):List<Seat> =
        purchases.map { it.seat }.distinct()
    private fun findSequence(seat: Seat): Int =
        getSeatIdList(purchaseRepository.findAll())
            .let { it.indexOf(seat) }
    override fun findPurchasedList(serialNumber: Long): List<PurchasedFoodListDto> =
        seatUtils.findSeatByStoreId(serialNumber)
            .map { PurchasedFoodListDto(it,getFoodInfo(it),0) }
}