package com.g3c1.temiuser.domain.category.entity

import com.g3c1.temiuser.global.entity.BaseIdEntity
import javax.persistence.*

@Entity
class Category(
    @Column(nullable = false)
    val name: String
) :BaseIdEntity()