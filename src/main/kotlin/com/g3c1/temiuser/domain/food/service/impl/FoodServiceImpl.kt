package com.g3c1.temiuser.domain.food.service.impl

import com.g3c1.temiuser.domain.category.domain.entity.Category
import com.g3c1.temiuser.domain.category.utils.CategoryUtils
import com.g3c1.temiuser.domain.food.domain.repository.FoodRepository
import com.g3c1.temiuser.domain.food.presentation.data.dto.CategoryFoodListDto
import com.g3c1.temiuser.domain.food.presentation.data.dto.FoodDto
import com.g3c1.temiuser.domain.food.service.FoodService
import org.springframework.stereotype.Service

@Service
class FoodServiceImpl(
    private val foodRepository: FoodRepository,
    private val categoryUtils: CategoryUtils
): FoodService {
    override fun findFoodListByCategory(): List<CategoryFoodListDto> = categoryUtils.findAllCategory().toList().map {category->
        CategoryFoodListDto(category.id,category.name,findFoodByCategory(category))
    }
    private fun findFoodByCategory(category: Category):List<FoodDto> =
        foodRepository.findByCategory(category).toList()
            .map { FoodDto(it.id,it.name,it.img,it.description,it.servings,it.price) }
}