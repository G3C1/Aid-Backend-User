package com.g3c1.temiuser.domain.store.presentation

import com.g3c1.temiuser.domain.store.presentation.data.response.StoreInfoResponse
import com.g3c1.temiuser.domain.store.service.StoreService
import com.g3c1.temiuser.domain.store.utils.StoreConverter
import org.jetbrains.annotations.NotNull
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v2/store")
class StoreController(
    private val storeService: StoreService,
    private val storeConverter: StoreConverter
) {
    @GetMapping("{serial_number}")
    fun findStoreBySerialNumber(@NotNull @PathVariable("serial_number") serialNumber: Long): ResponseEntity<StoreInfoResponse> =
        storeService.findStoreBySerialNumber(serialNumber)
            .let { storeConverter.toResponse(it) }
            .let { ResponseEntity.ok().body(it) }
}