package com.g3c1.temiuser.domain.seat.entity

import com.g3c1.temiuser.global.entity.BaseIdEntity

class Seat (
    val seatNumber: Long,
    val severalPeople: Long,
    val enabled: Boolean,
):BaseIdEntity()