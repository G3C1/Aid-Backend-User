package com.g3c1.temiuser.domain.purchase.presentaion

import com.g3c1.temiuser.domain.purchase.service.PurchaseServiceV2
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v2/purchase")
class PurchaseControllerV2(
    private val purchaseServiceV2: PurchaseServiceV2
) {
    @GetMapping("{seatId}")
    fun findPurchaseFoodListBySeatId(@NotNull @PathVariable seatId: Long){

    }
}