package com.g3c1.temiuser.domain.purchase.domain.entity

import com.g3c1.temiuser.domain.food.domain.entity.Food
import com.g3c1.temiuser.domain.seat.domain.entity.Seat
import com.g3c1.temiuser.global.entity.BaseIdEntity
import com.g3c1.temiuser.global.entity.BaseTimeEntity
import com.g3c1.temiuser.global.entity.BaseTimeIdEntity
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
class Purchase(
   @ManyToOne(fetch = FetchType.LAZY)
   @OnDelete(action = OnDeleteAction.CASCADE)
   @JoinColumn(nullable = true)
   val food: Food,
   @ManyToOne(fetch = FetchType.LAZY)
   @OnDelete(action = OnDeleteAction.CASCADE)
   @JoinColumn(nullable = true)
   val seat: Seat,
   val foodCount: Long,
   val storeId: Long
):BaseTimeIdEntity()