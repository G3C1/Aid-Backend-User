package com.g3c1.temiuser.domain.seat.domain.repository

import com.g3c1.temiuser.domain.seat.domain.entity.Seat
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface SeatRepository: CrudRepository<Seat,Long> {
    override fun findAll(): List<Seat>
    fun findSeatById(id: Long): Optional<Seat>
}