package com.g3c1.temiuser.domain.seat.service.impl

import com.g3c1.temiuser.domain.seat.presentation.data.dto.SeatInfoDto
import com.g3c1.temiuser.domain.seat.service.SeatServiceV2
import com.g3c1.temiuser.domain.seat.utils.SeatConverter
import com.g3c1.temiuser.domain.seat.utils.SeatUtils
import org.springframework.stereotype.Service

@Service
class SeatServiceV2Impl(
    private val seatUtils: SeatUtils,
    private val seatConverter: SeatConverter
):SeatServiceV2 {
    override fun findStoreByStoreId(storeId: Long): List<SeatInfoDto> {
        return seatUtils.findSeatByStoreId(storeId)
            .map(seatConverter::toDto)
    }
}