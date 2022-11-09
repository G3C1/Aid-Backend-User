package com.g3c1.temiuser.domain.seat.domain.entity

import com.g3c1.temiuser.domain.store.domain.entity.Store
import com.g3c1.temiuser.global.entity.BaseIdEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Seat (
    @Column(nullable = false)
    val seatNumber: Long,
    @Column(nullable = false)
    val severalPeople: Long,
    @Column(nullable = false)
    var enabled: Boolean,
    @ManyToOne
    @JoinColumn(name = "store_id")
    val store: Store
):BaseIdEntity()
