package com.g3c1.temiuser.domain.seat.utils.impl

import com.g3c1.temiuser.domain.seat.domain.entity.Seat
import com.g3c1.temiuser.domain.seat.exception.SeatAlreadyUsedException
import com.g3c1.temiuser.domain.seat.utils.SeatValidator
import org.springframework.stereotype.Component

@Component
class SeatValidator: SeatValidator {
    @Throws(SeatAlreadyUsedException::class)
    override fun checkIsUsed(seat: Seat) : Seat{
        return when {
            seat.enabled -> seat
            else -> throw SeatAlreadyUsedException()
        }
    }
}