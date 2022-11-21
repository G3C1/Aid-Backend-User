package com.g3c1.temiuser.domain.purchase.domain.repository

import com.g3c1.temiuser.domain.purchase.domain.entity.Purchase
import com.g3c1.temiuser.domain.seat.domain.entity.Seat
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface PurchaseRepository: CrudRepository<Purchase,Long> {
    @Query(value = "SELECT p FROM Purchase p group by p.id,p.seat,p.createdAt,p.foodCount,p.food order by p.createdAt DESC")
    override fun findAll(): List<Purchase>
    @Query(value = "select p from Purchase p join Seat s on p.seat.id = s.id left join Store st on s.store.serialNumber = st.serialNumber " +
            "where s.store.serialNumber = :serial_number order by p.createdAt DESC")
    fun findAllBySerialNumber(@Param("serial_number")serialNumber: Long):List<Purchase>
    fun findPurchaseBySeat(seat: Seat): List<Purchase>
}