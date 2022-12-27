package com.g3c1.temiuser.domain.seat.utils

import com.g3c1.temiuser.domain.purchase.presentaion.data.dto.FindPurchasedFoodDto
import com.g3c1.temiuser.domain.purchase.presentaion.data.request.FindPurchasedFoodRequest
import com.g3c1.temiuser.domain.seat.domain.entity.Seat
import com.g3c1.temiuser.domain.seat.presentation.data.dto.SeatInfoDto
import com.g3c1.temiuser.domain.seat.presentation.data.response.SeatInfoResponse

interface SeatConverter {
    fun toDto(seat: Seat): SeatInfoDto
    fun toResponse(it: List<SeatInfoDto>): List<SeatInfoResponse>
}