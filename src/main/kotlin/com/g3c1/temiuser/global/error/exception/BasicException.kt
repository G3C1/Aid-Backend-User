package com.g3c1.temiuser.global.error.exception

import com.g3c1.temiuser.global.error.ErrorCode

open class BasicException(
    val errorCode:ErrorCode
) :RuntimeException()