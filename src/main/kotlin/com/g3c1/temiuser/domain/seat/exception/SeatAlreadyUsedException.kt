package com.g3c1.temiuser.domain.seat.exception

import com.g3c1.temiuser.global.error.ErrorCode
import com.g3c1.temiuser.global.error.exception.BasicException

class SeatAlreadyUsedException: BasicException(ErrorCode.ALREADY_USED_SEAT)