package com.g3c1.temiuser.domain.category.domain.repository

import com.g3c1.temiuser.domain.category.domain.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category,Long>{
}