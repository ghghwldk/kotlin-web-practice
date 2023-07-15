package com.m.example.kotlin.springboot.rest.test.service.impl

import com.m.example.kotlin.springboot.rest.test.domain.entity.TestEntity
import com.m.example.kotlin.springboot.rest.test.repository.TestRepository
import com.m.example.kotlin.springboot.rest.test.service.TestService
import com.m.example.kotlin.springboot.rest.test.service.TestService2
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@RequiredArgsConstructor
class TestServiceImpl(
        val testRepository: TestRepository
) : TestService {
    @Transactional
    override fun test(): String{
        testRepository.save(TestEntity(name="test-name"))
        return "hi"
    }
}