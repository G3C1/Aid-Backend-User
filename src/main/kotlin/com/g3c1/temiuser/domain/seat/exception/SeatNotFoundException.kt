package com.g3c1.temiuser.domain.seat.exception

import com.g3c1.temiuser.global.error.ErrorCode
import com.g3c1.temiuser.global.error.exception.BasicException

class SeatNotFoundException: BasicException(ErrorCode.SEAT_NOT_FOUND)