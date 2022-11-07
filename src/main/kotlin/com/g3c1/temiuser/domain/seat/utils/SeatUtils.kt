package com.g3c1.temiuser.domain.seat.utils

import com.g3c1.temiuser.domain.seat.domain.entity.Seat

interface SeatUtils {
    fun findSeatById(seatId: Long): Seat
    fun findAll(): List<Seat>
}