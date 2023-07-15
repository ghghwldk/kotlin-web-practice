package com.m.example.kotlin.springboot.rest.category.service

import com.m.example.kotlin.springboot.rest.category.domain.entity.Category
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.m.example.kotlin.springboot.rest.category.repository.CategoryRepository
import com.m.example.kotlin.springboot.rest.global.service.PaginationService
import com.m.example.kotlin.springboot.rest.global.service.ValidateService
import com.m.example.kotlin.springboot.rest.product.repository.ProductRepository

@Service
class CategoryService(
        @Autowired val paginationService: PaginationService,
        @Autowired val validationService: ValidateService,
        @Autowired val categoryRepository: CategoryRepository,
        @Autowired val productRepository: ProductRepository
) {

    companion object {
        const val CATEGORY_NAME_MAX_SIZE = 70

        const val ITEM_VALIDATION_LOCATION_CATEGORY_NAME = "category.name"
        const val ITEM_VALIDATION_LOCATION_CATEGORY_PRODUCT = "category.product"
    }

    fun findById(id: Long)
        = categoryRepository.findById(id)
            .orElse(null)

    fun findAll(page: Int?, maxRecords: Int?) =
            paginationService.parseResult(page, maxRecords, categoryRepository::findAll)

    @Transactional
    fun save(category: Category) = category.let {
        validateSave(it)
        categoryRepository.save(it)
    }

    @Transactional
    fun delete(id: Long) {
        if (!categoryRepository.existsById(id)) {
            return
        }
        validateDelete(id)
        categoryRepository.deleteById(id)
    }

    private fun validateDelete(idCategory: Long) = validationService.apply {
        addItem(productRepository.existsByCategoriesId(idCategory),
                ITEM_VALIDATION_LOCATION_CATEGORY_PRODUCT,
                ValidateService.ITEM_VALIDATION_ERROR_TYPE_RELATIONSHIP)
    }.validate()

    private fun validateSave(category: Category) = validationService.apply {
        addItem(
                StringUtils.isBlank(category.name),
                ITEM_VALIDATION_LOCATION_CATEGORY_NAME,
                ValidateService.ITEM_VALIDATION_ERROR_TYPE_REQUIRED)
        addItem({ StringUtils.length(category.name) > CATEGORY_NAME_MAX_SIZE },
                ITEM_VALIDATION_LOCATION_CATEGORY_NAME,
                ValidateService.ITEM_VALIDATION_ERROR_TYPE_MAX_SIZE,
                listOf(CATEGORY_NAME_MAX_SIZE))
        addItem({ isDuplicateCategory(category) },
                ITEM_VALIDATION_LOCATION_CATEGORY_NAME,
                ValidateService.ITEM_VALIDATION_ERROR_TYPE_DUPLICATE)
    }.validate()

    private fun isDuplicateCategory(category: Category) =
            category.id?.let {
                categoryRepository.existsByIdNotAndNameIgnoreCase(it, category.name)
            } ?: categoryRepository.existsByNameIgnoreCase(category.name)
}
