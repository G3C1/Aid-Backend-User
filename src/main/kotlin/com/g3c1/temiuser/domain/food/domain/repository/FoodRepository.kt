package com.g3c1.temiuser.domain.food.domain.repository

import com.g3c1.temiuser.domain.category.domain.entity.Category
import com.g3c1.temiuser.domain.food.domain.entity.Food
import org.springframework.data.repository.CrudRepository
import java.util.*

interface FoodRepository: CrudRepository<Food,Long> {
    fun findByCategory(category: Category): List<Food>
    fun findFoodById(id: Long): Optional<Food>
}