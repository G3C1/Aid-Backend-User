package com.g3c1.temiuser.domain.seat.utils

import com.g3c1.temiuser.domain.seat.domain.entity.Seat

interface SeatValidator {
    fun checkIsUsed(seat:Seat) : Seat
}