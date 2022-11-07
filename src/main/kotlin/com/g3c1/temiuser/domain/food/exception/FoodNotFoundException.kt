package com.g3c1.temiuser.domain.food.exception

import com.g3c1.temiuser.global.error.ErrorCode
import com.g3c1.temiuser.global.error.exception.BasicException

class FoodNotFoundException: BasicException(ErrorCode.FOOD_NOT_FOUND)