package com.g3c1.temiuser.domain.purchase.exception

import com.g3c1.temiuser.global.error.ErrorCode
import com.g3c1.temiuser.global.error.exception.BasicException

class PurchaseNotFoundException: BasicException(ErrorCode.PURCHASE_NOT_FOUND) {
}