package com.g3c1.temiuser.domain.purchase.entity

import com.g3c1.temiuser.domain.food.entity.Food
import com.g3c1.temiuser.domain.seat.entity.Seat
import com.g3c1.temiuser.global.entity.BaseIdEntity
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class Purchase(
   @ManyToOne
   val food: Food,
   @ManyToOne
   val seat: Seat,
   val foodCount: Long
):BaseIdEntity()