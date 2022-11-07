package com.g3c1.temiuser.domain.purchase.presentaion

import com.g3c1.temiuser.domain.purchase.presentaion.data.request.PurchasedFoodRequest
import com.g3c1.temiuser.domain.purchase.service.PurchaseService
import com.g3c1.temiuser.domain.purchase.utils.PurchaseConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/purchase")
class PurchaseController(
    private val purchaseConverter: PurchaseConverter,
    private val purchaseService: PurchaseService
) {
    @PostMapping
    fun createPurchasedFoodList(purchasedFoodRequest: PurchasedFoodRequest): ResponseEntity<Void> =
        purchaseConverter.toDto(purchasedFoodRequest)
            .let {purchaseService.createPurchasedFoodList(it)}
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}