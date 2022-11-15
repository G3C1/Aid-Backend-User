package com.g3c1.temiuser.domain.food.service.impl

import com.g3c1.temiuser.domain.category.domain.entity.Category
import com.g3c1.temiuser.domain.category.utils.CategoryUtils
import com.g3c1.temiuser.domain.food.domain.repository.FoodRepository
import com.g3c1.temiuser.domain.food.presentation.data.dto.CategoryFoodListDto
import com.g3c1.temiuser.domain.food.service.FoodServiceV2
import com.g3c1.temiuser.domain.food.utils.FoodUtils
import com.g3c1.temiuser.domain.store.utils.StoreUtils
import org.springframework.stereotype.Service

@Service
class FoodServiceV2Impl(
    private val storeUtils: StoreUtils,
    private val categoryUtils: CategoryUtils,
    private val foodUtils: FoodUtils
): FoodServiceV2 {
    override fun findFoodListBySerialNumber(serialNumber: Long): List<CategoryFoodListDto> =
        storeUtils.findStoreBySerialNumber(serialNumber)
            .let { categoryUtils.findAllCategoryByStore(it) }
            .map { category-> CategoryFoodListDto(category.id,category.name,foodUtils.findFoodByCategory(category)) }
}