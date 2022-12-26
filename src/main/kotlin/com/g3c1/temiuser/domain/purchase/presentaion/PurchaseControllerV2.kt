package com.g3c1.temiuser.domain.purchase.presentaion

import com.g3c1.temiuser.domain.purchase.presentaion.data.response.MyPurchasedFoodListResponse
import com.g3c1.temiuser.domain.purchase.presentaion.data.response.PurchasedFoodListResponse
import com.g3c1.temiuser.domain.purchase.service.PurchaseServiceV2
import com.g3c1.temiuser.domain.purchase.utils.PurchaseConverter
import org.jetbrains.annotations.NotNull
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v2/purchase")
class PurchaseControllerV2(
    private val purchaseServiceV2: PurchaseServiceV2,
    private val purchaseConverter: PurchaseConverter
) {
    @GetMapping("{seat_id}")
    fun findPurchaseFoodListBySeatId(@NotNull @PathVariable("seat_id") seatId: Long):ResponseEntity<MyPurchasedFoodListResponse> =
        purchaseServiceV2.findFoodListBySeatId(seatId)
            .let { purchaseConverter.toResponse(it) }
            .let { ResponseEntity.ok(it) }
    @GetMapping("/find/{serial_number}")
    fun findPurchasedList(@NotNull @PathVariable("serial_number") serialNumber: Long): ResponseEntity<List<PurchasedFoodListResponse>> =
        purchaseServiceV2.findPurchasedList(serialNumber)
            .let { purchaseConverter.toResponse(it) }
            .let { ResponseEntity.ok(it) }
}