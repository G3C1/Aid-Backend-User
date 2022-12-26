package com.g3c1.temiuser.domain.purchase.presentaion

import com.g3c1.temiuser.domain.purchase.presentaion.data.request.PurchasedFoodRequest
import com.g3c1.temiuser.domain.purchase.presentaion.data.response.PurchasedFoodListResponse
import com.g3c1.temiuser.domain.purchase.service.PurchaseService
import com.g3c1.temiuser.domain.purchase.utils.PurchaseConverter
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/purchase")
class PurchaseController(
    private val purchaseConverter: PurchaseConverter,
    private val purchaseService: PurchaseService
) {
    @PostMapping
    fun createPurchasedFoodList(@Valid @RequestBody purchasedFoodRequest: PurchasedFoodRequest): ResponseEntity<Void> =
        purchaseConverter.toDto(purchasedFoodRequest)
            .let {purchaseService.createPurchasedFoodList(it)}
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
    @GetMapping
    fun findPurchasedList(): ResponseEntity<List<PurchasedFoodListResponse>> =
        purchaseService.findPurchasedList()
            .let { purchaseConverter.toResponse(it)}
            .let { ResponseEntity.ok(it) }
    @DeleteMapping("{seat_id}")
    fun deletePurchase(@NotNull @PathVariable("seat_id") seatId: Long):ResponseEntity<Void> =
        purchaseService.deletePurchase(seatId)
            .let { ResponseEntity.status(HttpStatus.NO_CONTENT).build() }
}