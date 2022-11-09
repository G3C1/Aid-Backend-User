package com.g3c1.temiuser.domain.seat.service

import com.g3c1.temiuser.domain.seat.presentation.data.dto.SeatInfoDto

interface SeatServiceV2 {
    fun findStoreByStoreId(storeId:Long): List<SeatInfoDto>
}