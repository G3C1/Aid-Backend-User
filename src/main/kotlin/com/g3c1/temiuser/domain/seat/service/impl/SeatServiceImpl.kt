package com.g3c1.temiuser.domain.seat.service.impl

import com.g3c1.temiuser.domain.seat.domain.repository.SeatRepository
import com.g3c1.temiuser.domain.seat.exception.SeatNotFoundException
import com.g3c1.temiuser.domain.seat.presentation.data.dto.SeatInfoDto
import com.g3c1.temiuser.domain.seat.service.SeatService
import com.g3c1.temiuser.domain.seat.utils.SeatConverter
import com.g3c1.temiuser.domain.seat.utils.SeatValidator
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SeatServiceImpl(
    private val seatConverter: SeatConverter,
    private val seatRepository: SeatRepository,
    private val seatValidator: SeatValidator
): SeatService {
    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    override fun findAllSeatInfo(): List<SeatInfoDto> = seatRepository.findAll()
        .map(seatConverter::toDto)
    @Transactional(rollbackFor = [Exception::class])
    override fun patchUsingSeat(seatId: Long) = seatRepository.findSeatById(seatId)
        .orElseThrow { SeatNotFoundException()}
        .let {seatValidator.checkIsUsed(it)}
        .let { it.enabled = false }

    override fun patchDisableUsingSeat(seatId: Long) = seatRepository.findSeatById(seatId)
        .orElseThrow { SeatNotFoundException()}
        .let {seatValidator.checkIsUsed(it)}
        .let { it.enabled = true }
}