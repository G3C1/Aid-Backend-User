package com.g3c1.temiuser.domain.store.domain.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Store(
    @Id
    @Column(name= "serial_number")
    val serialNumber:Long,
    val name: String,
    val description: String,
    val img: String
)
