package com.g3c1.temiuser.domain.category.utils

import com.g3c1.temiuser.domain.category.domain.entity.Category

interface CategoryUtils {
    fun findAllCategory(): List<Category>
}