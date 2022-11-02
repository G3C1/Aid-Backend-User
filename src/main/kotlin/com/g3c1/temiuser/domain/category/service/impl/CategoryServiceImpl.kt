package com.g3c1.temiuser.domain.category.service.impl

import com.g3c1.temiuser.domain.category.domain.repository.CategoryRepository
import com.g3c1.temiuser.domain.category.presentaion.data.dto.CategoryDto
import com.g3c1.temiuser.domain.category.presentaion.data.request.CreateCategoryRequest
import com.g3c1.temiuser.domain.category.service.CategoryService
import com.g3c1.temiuser.domain.category.utils.CategoryConverter
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl (
    private val categoryConverter: CategoryConverter,
    private val categoryRepository: CategoryRepository
): CategoryService{
    override fun createCategory(createCategoryDto: CategoryDto) {
        createCategoryDto
            .let {categoryConverter.toEntity(it)}
            .let{ categoryRepository.saveAll(it)}
    }
}