package com.g3c1.temiuser.domain.food.service.impl

import com.g3c1.temiuser.domain.category.domain.entity.Category
import com.g3c1.temiuser.domain.category.utils.CategoryUtils
import com.g3c1.temiuser.domain.food.domain.repository.FoodRepository
import com.g3c1.temiuser.domain.food.presentation.data.dto.CategoryFoodListDto
import com.g3c1.temiuser.domain.food.service.FoodService
import com.g3c1.temiuser.domain.food.utils.FoodUtils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FoodServiceImpl(
    private val categoryUtils: CategoryUtils,
    private val foodUtils: FoodUtils
): FoodService {
    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    override fun findFoodList(): List<CategoryFoodListDto> =
        categoryUtils.findAllCategory()
            .map {category-> CategoryFoodListDto(category.id,category.name,foodUtils.findFoodByCategory(category))
    }
}