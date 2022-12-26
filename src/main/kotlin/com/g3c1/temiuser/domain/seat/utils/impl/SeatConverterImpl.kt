package com.g3c1.temiuser.domain.seat.utils.impl

import com.g3c1.temiuser.domain.seat.domain.entity.Seat
import com.g3c1.temiuser.domain.seat.presentation.data.dto.SeatInfoDto
import com.g3c1.temiuser.domain.seat.presentation.data.response.SeatInfoResponse
import com.g3c1.temiuser.domain.seat.utils.SeatConverter
import org.springframework.stereotype.Component

@Component
class SeatConverterImpl: SeatConverter {
    override fun toDto(seat: Seat): SeatInfoDto = SeatInfoDto(seat.id, seat.seatNumber, seat.severalPeople, seat.locationX, seat.locationY, seat.enabled)
    override fun toResponse(it: List<SeatInfoDto>): List<SeatInfoResponse> = it.toList().map { SeatInfoResponse(it.idx, it.seatNumber, it.severalPeople, it.enabled) }
}
