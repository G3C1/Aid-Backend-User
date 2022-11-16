package com.g3c1.temiuser.domain.category.domain.entity

import com.g3c1.temiuser.domain.store.domain.entity.Store
import com.g3c1.temiuser.global.entity.BaseIdEntity
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
class Category(
    @Column(nullable = false)
    val name: String,
    @ManyToOne
    @JoinColumn(name = "store_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    val store:Store
) :BaseIdEntity()