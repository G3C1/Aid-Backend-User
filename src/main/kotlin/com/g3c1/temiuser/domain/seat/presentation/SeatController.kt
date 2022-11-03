package com.g3c1.temiuser.domain.seat.presentation

import com.g3c1.temiuser.domain.seat.presentation.data.response.SeatInfoResponse
import com.g3c1.temiuser.domain.seat.service.SeatService
import com.g3c1.temiuser.domain.seat.utils.SeatConverter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/seat")
class SeatController(
    private val seatConverter: SeatConverter,
    private val seatService: SeatService
) {
    @GetMapping
    fun findAllSeat(): ResponseEntity<List<SeatInfoResponse>> =
        seatService.findAllSeatInfo()
            .let { seatConverter.toResponse(it) }
            .let { ResponseEntity.ok().body(it) }
}