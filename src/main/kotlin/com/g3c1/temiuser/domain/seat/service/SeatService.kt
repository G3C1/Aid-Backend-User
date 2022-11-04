package com.g3c1.temiuser.domain.seat.service

import com.g3c1.temiuser.domain.seat.presentation.data.dto.SeatInfoDto

interface SeatService {
    fun findAllSeatInfo(): List<SeatInfoDto>
    fun patchUsingSeat(seatId: Long)
    fun patchDisableUsingSeat(seatId: Long)
}