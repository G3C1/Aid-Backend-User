package com.g3c1.temiuser.domain.seat.service.impl

import com.g3c1.temiuser.domain.seat.domain.repository.SeatRepository
import com.g3c1.temiuser.domain.seat.exception.SeatNotFoundException
import com.g3c1.temiuser.domain.seat.presentation.data.dto.SeatInfoDto
import com.g3c1.temiuser.domain.seat.service.SeatService
import com.g3c1.temiuser.domain.seat.utils.SeatConverter
import com.g3c1.temiuser.domain.seat.utils.SeatUtils
import com.g3c1.temiuser.domain.seat.utils.SeatValidator
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SeatServiceImpl(
    private val seatConverter: SeatConverter,
    private val seatUtils: SeatUtils,
    private val seatValidator: SeatValidator
): SeatService {
    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    override fun findAllSeatInfo(): List<SeatInfoDto> =
        seatUtils.findAll()
            .map(seatConverter::toDto)
    @Transactional(rollbackFor = [Exception::class])
    override fun patchUsingSeat(seatId: Long) =
        seatUtils.findSeatById(seatId)
            .let {seatValidator.checkIsUsed(it)}
            .let { it.enabled = false }

    @Transactional(rollbackFor = [Exception::class])
    override fun patchDisableUsingSeat(seatId: Long) =
        seatUtils.findSeatById(seatId)
            .let {seatValidator.checkIsNotUsed(it)}
            .let { it.enabled = true }
}