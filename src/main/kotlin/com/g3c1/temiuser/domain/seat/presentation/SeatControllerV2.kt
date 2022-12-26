package com.g3c1.temiuser.domain.seat.presentation

import com.g3c1.temiuser.domain.seat.presentation.data.response.SeatInfoResponse
import com.g3c1.temiuser.domain.seat.service.SeatServiceV2
import com.g3c1.temiuser.domain.seat.utils.SeatConverter
import org.jetbrains.annotations.NotNull
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v2/seat")
class SeatControllerV2(
    private val seatConverter: SeatConverter,
    private val seatServiceV2: SeatServiceV2
) {
    @GetMapping("{serial_number}")
    fun findSeatByStoreId(@NotNull @PathVariable("serial_number") serialNumber: Long): ResponseEntity<List<SeatInfoResponse>> =
        seatServiceV2.findSeatByStoreId(serialNumber)
            .let { seatConverter.toResponse(it) }
            .let { ResponseEntity.ok().body(it) }
}