package com.andrejusti.example.kotlin.springboot.rest.test.controller

import com.andrejusti.example.kotlin.springboot.rest.global.exception.ValidationException
import com.andrejusti.example.kotlin.springboot.rest.test.service.TestService
import com.andrejusti.example.kotlin.springboot.rest.test.service.TestService2
import com.andrejusti.example.kotlin.springboot.rest.test.service.impl.TestServiceImpl
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct

@RestController
@RequiredArgsConstructor
class TestController(
        val testService: TestService,
        val testService2: TestService2
){
    val logger: Logger = LoggerFactory.getLogger(TestController::class.java)

    companion object {
        const val DOMAIN_URI: String = "/test"
        const val URI_1: String = "1"
        const val URI_2: String = "2"
        const val URL1: String = "$DOMAIN_URI/$URI_1"
        const val URL2: String = "$DOMAIN_URI/$URI_2"
    }

    @GetMapping(URL1)
    fun test(): String{
        val testMap: HashMap<String, String> = HashMap()
        testMap.put("a", "a")
        logger.info("test called")
        return testService.test()
    }

    @GetMapping(URL2)
    fun test2(): String{
        logger.info("test2 called")
        return testService2.test()
    }
}
