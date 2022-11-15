package com.g3c1.temiuser.domain.food.utils.impl

import com.g3c1.temiuser.domain.category.domain.entity.Category
import com.g3c1.temiuser.domain.food.domain.entity.Food
import com.g3c1.temiuser.domain.food.domain.repository.FoodRepository
import com.g3c1.temiuser.domain.food.exception.FoodNotFoundException
import com.g3c1.temiuser.domain.food.presentation.data.dto.CategoryFoodListDto
import com.g3c1.temiuser.domain.food.utils.FoodUtils
import org.springframework.stereotype.Component

@Component
class FoodUtilsImpl(
    private val foodRepository: FoodRepository
): FoodUtils {
    override fun findFoodBySeatId(seatId: Long): Food =
        foodRepository.findFoodById(seatId).orElseThrow { FoodNotFoundException() }

    override fun findFoodByCategory(category: Category): List<CategoryFoodListDto.FoodDto> =
        foodRepository.findByCategory(category)
            .map { CategoryFoodListDto.FoodDto(it.id,it.name,it.img,it.description,it.servings,it.price) }

}