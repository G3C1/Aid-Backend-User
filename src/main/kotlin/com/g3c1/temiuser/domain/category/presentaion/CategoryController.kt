package com.g3c1.temiuser.domain.category.presentaion

import com.g3c1.temiuser.domain.category.presentaion.data.request.CreateCategoryRequest
import com.g3c1.temiuser.domain.category.service.CategoryService
import com.g3c1.temiuser.domain.category.utils.CategoryConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/category")
class CategoryController (
    private val categoryConverter: CategoryConverter,
    private val categoryService: CategoryService
){
    @PostMapping
    fun createCategory(@RequestBody createCategoryRequest: CreateCategoryRequest):ResponseEntity<Void> {
        categoryConverter.toDto(createCategoryRequest)
            .let { categoryService.createCategory(it) }
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}