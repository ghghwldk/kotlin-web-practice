package com.m.example.kotlin.springboot.rest.clientapi

import org.springframework.stereotype.Component
import org.springframework.web.util.UriComponentsBuilder
import com.m.example.kotlin.springboot.rest.controller.endpointmessage.CategoryController
import com.m.example.kotlin.springboot.rest.global.dto.Pagination
import com.m.example.kotlin.springboot.rest.global.dto.ResultPage
import com.m.example.kotlin.springboot.rest.category.domain.entity.Category

@Component
class CategoryClientApi : AbstractClientApi() {

    fun findById(id: Long) =
            testRestTemplate.getForEntity("${CategoryController.URI_PATH_CATEGORY}/$id", Category::class.java)
                    ?.body

    fun findAll(pagination: Pagination): ResultPage<Category> {
        val queryParams = createPaginationQueryParams(pagination)
        val uri = UriComponentsBuilder.fromPath(CategoryController.URI_PATH_CATEGORY).queryParams(queryParams).toUriString()
        val body = testRestTemplate.getForObject(uri, String::class.java)
        return parseBodyGenerics<ResultPage<Category>>(body)
    }

    fun create(category: Category) =
            testRestTemplate.postForLocation(CategoryController.URI_PATH_CATEGORY, category)
                    ?.let { parseUriLocationId(it) }

    fun edit(category: Category) = testRestTemplate.put("${CategoryController.URI_PATH_CATEGORY}/${category.id}", category)

    fun delete(id: Long) = testRestTemplate.delete("${CategoryController.URI_PATH_CATEGORY}/$id")
}