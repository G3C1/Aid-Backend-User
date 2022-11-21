package com.g3c1.temiuser.domain.purchase.domain.repository

import com.g3c1.temiuser.domain.purchase.domain.entity.Purchase
import com.g3c1.temiuser.domain.seat.domain.entity.Seat
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface PurchaseRepository: CrudRepository<Purchase,Long> {
    @Query(value = "SELECT purchase FROM Purchase purchase group by purchase.id,purchase.seat,purchase.createdAt,purchase.foodCount,purchase.food order by purchase.createdAt DESC")
    override fun findAll(): List<Purchase>
    fun findAllBySeatOrderByCreatedAtDesc(seat: Seat): List<Purchase>
    fun findPurchaseBySeat(seat: Seat): List<Purchase>
}