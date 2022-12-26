package com.g3c1.temiuser.domain.seat.presentation.data.response

data class SeatInfoResponse(
    val seatId: Long,
    val seatNumber: Long,
    val severalPeople: Long,
    val location: Location,
    val enabled: Boolean
) {
    data class Location (
        val x: Float,
        val y: Float
    )
}
