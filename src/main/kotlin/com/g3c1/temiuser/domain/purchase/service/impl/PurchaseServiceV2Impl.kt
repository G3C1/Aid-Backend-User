package com.g3c1.temiuser.domain.purchase.service.impl

import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.PurchasedFoodListDto
import com.g3c1.temiuser.domain.purchase.service.PurchaseServiceV2
import org.springframework.stereotype.Service

@Service
class PurchaseServiceV2Impl:PurchaseServiceV2 {
    override fun findFoodListBySeatId(seatId: Long): PurchasedFoodListDto {
        TODO("Not yet implemented")
    }
}