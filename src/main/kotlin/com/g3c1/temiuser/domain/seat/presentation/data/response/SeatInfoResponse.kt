package com.g3c1.temiuser.domain.seat.presentation.data.response

data class SeatInfoResponse(
    val seatId: Long,
    val seatNumber: Long,
    val severalPeople: Long,
    val x: Float,
    val y: Float,
    val enabled: Boolean
)
