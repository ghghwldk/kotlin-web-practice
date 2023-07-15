package com.m.example.kotlin.springboot.rest.clientapi

import org.springframework.stereotype.Component
import org.springframework.web.util.UriComponentsBuilder
import com.m.example.kotlin.springboot.rest.global.dto.Pagination
import com.m.example.kotlin.springboot.rest.global.dto.ResultPage
import com.m.example.kotlin.springboot.rest.product.controller.ProductController
import com.m.example.kotlin.springboot.rest.product.domain.entity.Product


@Component
class ProductClientApi : AbstractClientApi() {

    companion object {
        const val QUERY_PARAM_KEY_PAGINATION_NAME: String = "name"
    }

    fun findById(id: Long) =
            testRestTemplate.getForEntity("${ProductController.URI_PATH_PRODUCT}/$id", Product::class.java)
                    ?.body

    fun findAll(pagination: Pagination, name: String): ResultPage<Product> {
        val queryParams = createPaginationQueryParams(pagination, mapOf(QUERY_PARAM_KEY_PAGINATION_NAME to name))
        val uri = UriComponentsBuilder.fromPath(ProductController.URI_PATH_PRODUCT).queryParams(queryParams).toUriString()
        val body = testRestTemplate.getForObject(uri, String::class.java)
        return parseBodyGenerics<ResultPage<Product>>(body)
    }

    fun create(product: Product) =
            testRestTemplate.postForLocation(ProductController.URI_PATH_PRODUCT, product)
                    ?.let { parseUriLocationId(it) }

    fun edit(product: Product) = testRestTemplate.put("${ProductController.URI_PATH_PRODUCT}/${product.id}", product)

    fun delete(id: Long) = testRestTemplate.delete("${ProductController.URI_PATH_PRODUCT}/$id")
}