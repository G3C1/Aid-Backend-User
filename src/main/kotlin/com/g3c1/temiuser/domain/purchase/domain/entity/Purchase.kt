package com.g3c1.temiuser.domain.purchase.domain.entity

import com.g3c1.temiuser.domain.food.domain.entity.Food
import com.g3c1.temiuser.domain.seat.domain.entity.Seat
import com.g3c1.temiuser.global.entity.BaseIdEntity
import com.g3c1.temiuser.global.entity.BaseTimeEntity
import com.g3c1.temiuser.global.entity.BaseTimeIdEntity
import javax.persistence.*

@Entity
class Purchase(
   @ManyToOne
   val food: Food,
   @ManyToOne
   val seat: Seat,
   val foodCount: Long
):BaseTimeIdEntity()