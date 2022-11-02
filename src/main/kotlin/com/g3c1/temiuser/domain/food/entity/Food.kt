package com.g3c1.temiuser.domain.food.entity

import com.g3c1.temiuser.domain.category.domain.entity.Category
import com.g3c1.temiuser.global.entity.BaseIdEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Food (
    @Column(nullable = false)
    val name: String,
    @Column(nullable = false)
    val img: String,
    @Column(nullable = false)
    val description: String,
    @Column(nullable = false)
    val price: Long,
    @Column(nullable = false)
    val servings: Long,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    val category: Category
):BaseIdEntity()