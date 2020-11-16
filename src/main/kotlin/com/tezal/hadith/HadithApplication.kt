package com.tezal.hadith

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HadithApplication

fun main(args: Array<String>) {
    runApplication<HadithApplication>(*args)
}
