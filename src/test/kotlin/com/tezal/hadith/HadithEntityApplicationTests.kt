package com.tezal.hadith

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner
import kotlin.jvm.Throws


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HadithEntityApplicationTests {

    @LocalServerPort
    private val port = 0

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    @Throws(Exception::class)
    fun shouldReturn200WhenSendingRequestToController() {
        val res = testRestTemplate.getForEntity("/api/status/findAll", ArrayList::class.java)
        assertNotNull(res)
        assertEquals(res.statusCode, HttpStatus.OK)
        println(res.body)
    }


}
