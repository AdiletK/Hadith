package com.tezal.hadith.controller.statics

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {
    @GetMapping
    fun main() : String{
        return "Welcome to hadith api"
    }

}