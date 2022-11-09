package com.g3c1.temiuser.domain.store.exception

import com.g3c1.temiuser.global.error.ErrorCode
import com.g3c1.temiuser.global.error.exception.BasicException

class StoreNotFoundException: BasicException(ErrorCode.STORE_NOT_FOUND)