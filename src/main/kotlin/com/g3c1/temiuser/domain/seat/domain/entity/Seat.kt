package com.g3c1.temiuser.domain.seat.domain.entity

import com.g3c1.temiuser.global.entity.BaseIdEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Seat (
    @Column(nullable = false)
    val seatNumber: Long,
    @Column(nullable = false)
    val severalPeople: Long,
    @Column(nullable = false)
    var enabled: Boolean,
):BaseIdEntity()
