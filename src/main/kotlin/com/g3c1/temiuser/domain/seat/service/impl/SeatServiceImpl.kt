package com.g3c1.temiuser.domain.seat.service.impl

import com.g3c1.temiuser.domain.seat.domain.repository.SeatRepository
import com.g3c1.temiuser.domain.seat.presentation.data.dto.SeatInfoDto
import com.g3c1.temiuser.domain.seat.service.SeatService
import com.g3c1.temiuser.domain.seat.utils.SeatConverter
import org.springframework.stereotype.Service

@Service
class SeatServiceImpl(
    private val seatConverter: SeatConverter,
    private val seatRepository: SeatRepository
): SeatService {
    override fun findAllSeatInfo(): List<SeatInfoDto> = seatRepository.findAll()
        .map(seatConverter::toDto)
}