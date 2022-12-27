package com.g3c1.temiuser.domain.purchase.service.impl

import com.g3c1.temiuser.domain.food.exception.FoodNotFoundException
import com.g3c1.temiuser.domain.purchase.domain.entity.Purchase
import com.g3c1.temiuser.domain.purchase.domain.repository.PurchaseRepository
import com.g3c1.temiuser.domain.purchase.exception.PurchaseNotFoundException
import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.FindPurchasedFoodDto
import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.PurchasedFoodListDto
import com.g3c1.temiuser.domain.purchase.service.PurchaseServiceV2
import com.g3c1.temiuser.domain.seat.domain.entity.Seat
import com.g3c1.temiuser.domain.seat.exception.SeatNotFoundException
import com.g3c1.temiuser.domain.seat.utils.SeatUtils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PurchaseServiceV2Impl(
    private val purchaseRepository: PurchaseRepository,
    private val seatUtils: SeatUtils,
):PurchaseServiceV2 {
    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    override fun findFoodListBySeatId(param: FindPurchasedFoodDto): PurchasedFoodListDto =
        seatUtils.findSeatById(param.seatId)
            .let { PurchasedFoodListDto(it,getFoodInfo(it),findSequence(it,param.serialNumber)) }
    private fun getFoodInfo(seat: Seat): List<PurchasedFoodListDto.FoodInfoDto> =
        purchaseRepository.findPurchaseBySeat(seat)
            .map { PurchasedFoodListDto.FoodInfoDto(it.food,it.foodCount) }
    private fun getSeatList(purchases: List<Purchase>):List<Seat> =
        purchases.map { it.seat }.distinct()
    private fun findSequence(seat: Seat,serialNumber: Long): Int =
        getSeatList(purchaseRepository.findPurchaseByStoreId(serialNumber))
            .let { it.indexOf(seat) }
            .let { if(it > -1) it else throw PurchaseNotFoundException() }
    override fun findPurchasedList(serialNumber: Long): List<PurchasedFoodListDto> =
        getSeatList(purchaseRepository.findAllBySerialNumber(serialNumber))
                 .let { seat -> seat.map { PurchasedFoodListDto(it, getFoodInfo(it), 0) } }
}