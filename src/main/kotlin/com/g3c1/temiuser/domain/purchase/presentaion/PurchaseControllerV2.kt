package com.g3c1.temiuser.domain.purchase.presentaion

import com.g3c1.temiuser.domain.purchase.presentaion.data.request.FindPurchasedFoodRequest
import com.g3c1.temiuser.domain.purchase.presentaion.data.response.MyPurchasedFoodListResponse
import com.g3c1.temiuser.domain.purchase.presentaion.data.response.PurchasedFoodListResponse
import com.g3c1.temiuser.domain.purchase.service.PurchaseServiceV2
import com.g3c1.temiuser.domain.purchase.utils.PurchaseConverter
import org.jetbrains.annotations.NotNull
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("api/v2/purchase")
class PurchaseControllerV2(
    private val purchaseServiceV2: PurchaseServiceV2,
    private val purchaseConverter: PurchaseConverter
) {
    @GetMapping
    fun findPurchaseFoodListBySeatId(@RequestBody param: FindPurchasedFoodRequest):ResponseEntity<MyPurchasedFoodListResponse> =
        purchaseConverter.toDto(param)
            .let{purchaseServiceV2.findFoodListBySeatId(it)}
            .let { purchaseConverter.toResponse(it) }
            .let { ResponseEntity.ok(it) }
    @GetMapping("/find/{serial_number}")
    fun findPurchasedList(@NotNull @PathVariable("serial_number") serialNumber: Long): ResponseEntity<List<PurchasedFoodListResponse>> =
        purchaseServiceV2.findPurchasedList(serialNumber)
            .let { purchaseConverter.toResponse(it) }
            .let { ResponseEntity.ok(it) }
}