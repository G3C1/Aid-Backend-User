package com.g3c1.temiuser.domain.seat.exception

import com.g3c1.temiuser.global.error.ErrorCode
import com.g3c1.temiuser.global.error.exception.BasicException

class SeatNotUsedException: BasicException(ErrorCode.SEAT_NOT_USED) {
}