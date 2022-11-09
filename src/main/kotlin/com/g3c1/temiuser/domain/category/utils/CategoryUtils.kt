package com.g3c1.temiuser.domain.category.utils

import com.g3c1.temiuser.domain.category.domain.entity.Category
import com.g3c1.temiuser.domain.store.domain.entity.Store

interface CategoryUtils {
    fun findAllCategory(): List<Category>
    fun findAllCategoryByStore(store: Store): List<Category>
}