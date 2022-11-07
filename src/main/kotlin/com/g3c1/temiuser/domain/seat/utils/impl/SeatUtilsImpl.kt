package com.g3c1.temiuser.domain.seat.utils.impl

import com.g3c1.temiuser.domain.seat.domain.entity.Seat
import com.g3c1.temiuser.domain.seat.domain.repository.SeatRepository
import com.g3c1.temiuser.domain.seat.exception.SeatNotFoundException
import com.g3c1.temiuser.domain.seat.utils.SeatUtils
import org.springframework.stereotype.Component

@Component
class SeatUtilsImpl(
    private val seatRepository: SeatRepository
): SeatUtils{
    override fun findSeatById(seatId: Long): Seat =
        seatRepository.findSeatById(seatId).orElseThrow { SeatNotFoundException() }

    override fun findAll(): List<Seat> = seatRepository.findAll()
}