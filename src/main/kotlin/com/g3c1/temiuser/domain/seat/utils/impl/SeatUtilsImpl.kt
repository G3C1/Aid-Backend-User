package com.g3c1.temiuser.domain.seat.utils.impl

import com.g3c1.temiuser.domain.seat.domain.entity.Seat
import com.g3c1.temiuser.domain.seat.domain.repository.SeatRepository
import com.g3c1.temiuser.domain.seat.exception.SeatNotFoundException
import com.g3c1.temiuser.domain.seat.utils.SeatUtils
import com.g3c1.temiuser.domain.store.utils.StoreUtils
import org.springframework.stereotype.Component

@Component
class SeatUtilsImpl(
    private val seatRepository: SeatRepository,
    private val storeUtils: StoreUtils
): SeatUtils{
    override fun findSeatById(seatId: Long): Seat =
        seatRepository.findSeatById(seatId).orElseThrow { SeatNotFoundException() }

    override fun findAll(): List<Seat> = seatRepository.findAll()
    override fun findSeatByStoreId(store: Long): List<Seat> =
        storeUtils.findStoreBySerialNumber(store)
            .let { seatRepository.findAllByStore(it) }
}