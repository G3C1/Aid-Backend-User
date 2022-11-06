package com.g3c1.temiuser.domain.category.utils.impl

import com.g3c1.temiuser.domain.category.domain.entity.Category
import com.g3c1.temiuser.domain.category.domain.repository.CategoryRepository
import com.g3c1.temiuser.domain.category.utils.CategoryUtils
import org.springframework.stereotype.Component

@Component
class CategoryUtilsImpl(
    private val categoryRepository: CategoryRepository
):CategoryUtils {
    override fun findAllCategory(): List<Category> = categoryRepository.findAll()
}