package com.g3c1.temiuser.domain.category.domain.repository

import com.g3c1.temiuser.domain.category.domain.entity.Category
import com.g3c1.temiuser.domain.store.domain.entity.Store
import org.springframework.data.repository.CrudRepository

interface CategoryRepository:CrudRepository<Category,Long> {
    override fun findAll(): List<Category>
    fun findAllByStore(store: Store): List<Category>
}